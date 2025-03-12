package DB;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/tourism_company";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        createTables();
    }

    public static void createTables() {
        String sqlClients = "CREATE TABLE IF NOT EXISTS Clients (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) UNIQUE NOT NULL, " +
                "phone VARCHAR(15) NOT NULL)";

        String sqlTours = "CREATE TABLE IF NOT EXISTS Tours (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "description TEXT, " +
                "price DECIMAL(10, 2) NOT NULL)";

        String sqlBookings = "CREATE TABLE IF NOT EXISTS Bookings (" +
                "id SERIAL PRIMARY KEY, " +
                "client_id INT REFERENCES Clients(id), " +
                "tour_id INT REFERENCES Tours(id), " +
                "booking_date DATE NOT NULL)";

        String sqlDestinations = "CREATE TABLE IF NOT EXISTS Destinations (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "country VARCHAR(100) NOT NULL)";

        String sqlPayments = "CREATE TABLE IF NOT EXISTS Payments (" +
                "id SERIAL PRIMARY KEY, " +
                "booking_id INT REFERENCES Bookings(id), " +
                "amount DECIMAL(10, 2) NOT NULL, " +
                "payment_date DATE NOT NULL)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlClients);
            stmt.execute(sqlTours);
            stmt.execute(sqlBookings);
            stmt.execute(sqlDestinations);
            stmt.execute(sqlPayments);
            System.out.println("Таблицы успешно созданы");
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблиц " + e.getMessage());
        }
    }
}