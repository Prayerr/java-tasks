package DB;

import java.sql.*;

public class DataManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/tourism_company";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public static void addClient(String name, String email, String phone) {
        String sql = "INSERT INTO Clients (name, email, phone) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            System.out.println("Клиент добавлен " + name);
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении клиента " + e.getMessage());
        }
    }

    public static void addTour(String name, String description, double price) {
        String sql = "INSERT INTO Tours (name, description, price) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
            System.out.println("Тур добавлен " + name);
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении тура " + e.getMessage());
        }
    }

    public static void addBooking(int clientId, int tourId, String bookingDate) {
        String sql = "INSERT INTO Bookings (client_id, tour_id, booking_date) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clientId);
            pstmt.setInt(2, tourId);
            pstmt.setDate(3, java.sql.Date.valueOf(bookingDate));
            pstmt.executeUpdate();
            System.out.println("Бронирование добавлено");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении бронирования " + e.getMessage());
        }
    }

    public static void addDestination(String name, String country) {
        String sql = "INSERT INTO Destinations (name, country) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.executeUpdate();
            System.out.println("Направление добавлено " + name);
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении направления " + e.getMessage());
        }
    }

    public static void addPayment(int bookingId, double amount, String paymentDate) {
        String sql = "INSERT INTO Payments (booking_id, amount, payment_date) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookingId);
            pstmt.setDouble(2, amount);
            pstmt.setDate(3, java.sql.Date.valueOf(paymentDate));
            pstmt.executeUpdate();
            System.out.println("Платеж добавлен");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении платежа " + e.getMessage());
        }
    }

    public static void deleteClient(int id) {
        String sql = "DELETE FROM Clients WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Клиент удален ID " + id);
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении клиента: " + e.getMessage());
        }
    }

    public static void updateClient(int id, String name, String email, String phone) {
        String sql = "UPDATE Clients SET name = ?, email = ?, phone = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Клиент обновлен: ID " + id);
        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении клиента: " + e.getMessage());
        }
    }

    public static void printAllClients() {
        String sql = "SELECT * FROM Clients";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Имя: " + rs.getString("name") +
                        ", Email: " + rs.getString("email") +
                        ", Телефон: " + rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при выводе клиентов: " + e.getMessage());
        }
    }

    public static void printClientsByName(String name) {
        String sql = "SELECT * FROM Clients WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Имя: " + rs.getString("name") +
                        ", Email: " + rs.getString("email") +
                        ", Телефон: " + rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при выводе клиентов: " + e.getMessage());
        }
    }
}
