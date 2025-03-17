import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private static final double WELCOME_BONUS = 1000.0;

    public void createClient(Client client) throws SQLException {
        String sql = "INSERT INTO clients (full_name, account_number, balance, client_type, welcome_bonus_used) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getFullName());
            pstmt.setString(2, client.getAccountNumber());
            pstmt.setDouble(3, client.getBalance());
            pstmt.setString(4, client.getClientType().name());
            pstmt.setBoolean(5, client.isWelcomeBonusUsed());
            pstmt.executeUpdate();
        }
    }

    public void transferMoney(String fromAccount, String toAccount, double amount) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            String checkBalanceSql = "SELECT balance FROM clients WHERE account_number = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(checkBalanceSql)) {
                pstmt.setString(1, fromAccount);
                ResultSet rs = pstmt.executeQuery();
                if (!rs.next() || rs.getDouble("balance") < amount) {
                    throw new SQLException("Недостаточно средств на счете");
                }
            }

            String updateFromSql = "UPDATE clients SET balance = balance - ? WHERE account_number = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateFromSql)) {
                pstmt.setDouble(1, amount);
                pstmt.setString(2, fromAccount);
                pstmt.executeUpdate();
            }

            String updateToSql = "UPDATE clients SET balance = balance + ? WHERE account_number = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateToSql)) {
                pstmt.setDouble(1, amount);
                pstmt.setString(2, toAccount);
                pstmt.executeUpdate();
            }

            String transactionSql = "INSERT INTO transactions (from_account, to_account, amount, transaction_type) VALUES (?, ?, ?, 'TRANSFER')";
            try (PreparedStatement pstmt = conn.prepareStatement(transactionSql)) {
                pstmt.setString(1, fromAccount);
                pstmt.setString(2, toAccount);
                pstmt.setDouble(3, amount);
                pstmt.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    public void payService(String accountNumber, double amount) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            String getClientSql = "SELECT * FROM clients WHERE account_number = ?";
            Client client;
            try (PreparedStatement pstmt = conn.prepareStatement(getClientSql)) {
                pstmt.setString(1, accountNumber);
                ResultSet rs = pstmt.executeQuery();
                if (!rs.next()) {
                    throw new SQLException("Клиент не найден");
                }
                client = new Client(
                    rs.getString("full_name"),
                    rs.getString("account_number"),
                    ClientType.valueOf(rs.getString("client_type"))
                );
                client.setBalance(rs.getDouble("balance"));
                client.setWelcomeBonusUsed(rs.getBoolean("welcome_bonus_used"));
            }

            if (client.getBalance() < amount) {
                throw new SQLException("Недостаточно средств на счете");
            }

            double cashback = client.calculateCashback(amount);

            String updateBalanceSql = "UPDATE clients SET balance = balance - ? WHERE account_number = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateBalanceSql)) {
                pstmt.setDouble(1, amount);
                pstmt.setString(2, accountNumber);
                pstmt.executeUpdate();
            }

            if (!client.isWelcomeBonusUsed()) {
                String updateBonusSql = "UPDATE clients SET balance = balance + ?, welcome_bonus_used = true WHERE account_number = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(updateBonusSql)) {
                    pstmt.setDouble(1, WELCOME_BONUS);
                    pstmt.setString(2, accountNumber);
                    pstmt.executeUpdate();
                }
            }

            if (cashback > 0) {
                String updateCashbackSql = "UPDATE clients SET balance = balance + ? WHERE account_number = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(updateCashbackSql)) {
                    pstmt.setDouble(1, cashback);
                    pstmt.setString(2, accountNumber);
                    pstmt.executeUpdate();
                }
            }

            String transactionSql = "INSERT INTO transactions (from_account, amount, transaction_type) VALUES (?, ?, 'SERVICE_PAYMENT')";
            try (PreparedStatement pstmt = conn.prepareStatement(transactionSql)) {
                pstmt.setString(1, accountNumber);
                pstmt.setDouble(2, amount);
                pstmt.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Client client = new Client(
                    rs.getString("full_name"),
                    rs.getString("account_number"),
                    ClientType.valueOf(rs.getString("client_type"))
                );
                client.setBalance(rs.getDouble("balance"));
                client.setWelcomeBonusUsed(rs.getBoolean("welcome_bonus_used"));
                clients.add(client);
            }
        }
        return clients;
    }

    public Client getClientByAccountNumber(String accountNumber) throws SQLException {
        String sql = "SELECT * FROM clients WHERE account_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Client client = new Client(
                    rs.getString("full_name"),
                    rs.getString("account_number"),
                    ClientType.valueOf(rs.getString("client_type"))
                );
                client.setBalance(rs.getDouble("balance"));
                client.setWelcomeBonusUsed(rs.getBoolean("welcome_bonus_used"));
                return client;
            }
        }
        return null;
    }

    public void updateClient(Client client) throws SQLException {
        String sql = "UPDATE clients SET full_name = ?, balance = ?, client_type = ?, welcome_bonus_used = ? WHERE account_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getFullName());
            pstmt.setDouble(2, client.getBalance());
            pstmt.setString(3, client.getClientType().name());
            pstmt.setBoolean(4, client.isWelcomeBonusUsed());
            pstmt.setString(5, client.getAccountNumber());
            pstmt.executeUpdate();
        }
    }

    public void deleteClient(String accountNumber) throws SQLException {
        String sql = "DELETE FROM clients WHERE account_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountNumber);
            pstmt.executeUpdate();
        }
    }
} 