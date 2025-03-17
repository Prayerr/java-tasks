import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final BankService bankService = new BankService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            initializeDatabase();
            createInitialClients();
            showMenu();
        } catch (SQLException e) {
            System.out.println("Ошибка при работе с базой данных: " + e.getMessage());
        }
    }

    private static void initializeDatabase() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String createClientsTable = "CREATE TABLE IF NOT EXISTS clients (" +
                "id SERIAL PRIMARY KEY," +
                "full_name VARCHAR(100) NOT NULL," +
                "account_number VARCHAR(20) UNIQUE NOT NULL," +
                "balance DECIMAL(15,2) DEFAULT 0," +
                "client_type VARCHAR(10) NOT NULL," +
                "welcome_bonus_used BOOLEAN DEFAULT FALSE" +
                ")";
            
            String createTransactionsTable = "CREATE TABLE IF NOT EXISTS transactions (" +
                "id SERIAL PRIMARY KEY," +
                "from_account VARCHAR(20) REFERENCES clients(account_number)," +
                "to_account VARCHAR(20) REFERENCES clients(account_number)," +
                "amount DECIMAL(15,2) NOT NULL," +
                "transaction_type VARCHAR(20) NOT NULL," +
                "transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";
            
            stmt.execute(createClientsTable);
            stmt.execute(createTransactionsTable);
            
            System.out.println("База данных инициализирована");
        }
    }

    private static void createInitialClients() throws SQLException {
        for (int i = 0; i < 5; i++) {
            Client client = new Client(
                "Базовый клиент " + (i + 1),
                generateAccountNumber(),
                ClientType.BASIC
            );
            bankService.createClient(client);
        }

        for (int i = 0; i < 5; i++) {
            Client client = new Client(
                "Премиум клиент " + (i + 1),
                generateAccountNumber(),
                ClientType.PREMIUM
            );
            bankService.createClient(client);
        }

        for (int i = 0; i < 5; i++) {
            Client client = new Client(
                "VIP клиент " + (i + 1),
                generateAccountNumber(),
                ClientType.VIP
            );
            bankService.createClient(client);
        }
    }

    private static String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    private static void showMenu() throws SQLException {
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Показать всех клиентов");
            System.out.println("2. Перевести деньги");
            System.out.println("3. Оплатить услугу");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showAllClients();
                    break;
                case 2:
                    transferMoney();
                    break;
                case 3:
                    payService();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private static void showAllClients() throws SQLException {
        List<Client> clients = bankService.getAllClients();
        System.out.println("\nСписок всех клиентов:");
        for (Client client : clients) {
            System.out.printf("ФИО: %s, Номер счета: %s, Баланс: %.2f, Тип: %s%n",
                client.getFullName(),
                client.getAccountNumber(),
                client.getBalance(),
                client.getClientType());
        }
    }

    private static void transferMoney() throws SQLException {
        System.out.println("Введите номер счета отправителя:");
        String fromAccount = scanner.nextLine();
        System.out.println("Введите номер счета получателя:");
        String toAccount = scanner.nextLine();
        System.out.println("Введите сумму перевода:");
        double amount = scanner.nextDouble();

        try {
            bankService.transferMoney(fromAccount, toAccount, amount);
            System.out.println("Перевод успешно выполнен");
        } catch (SQLException e) {
            System.out.println("Ошибка при переводе: " + e.getMessage());
        }
    }

    private static void payService() throws SQLException {
        System.out.println("Введите номер счета:");
        String accountNumber = scanner.nextLine();
        System.out.println("Введите сумму оплаты:");
        double amount = scanner.nextDouble();

        try {
            bankService.payService(accountNumber, amount);
            System.out.println("Услуга успешно оплачена");
        } catch (SQLException e) {
            System.out.println("Ошибка при оплате услуги: " + e.getMessage());
        }
    }
} 