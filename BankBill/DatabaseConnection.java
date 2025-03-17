import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/bank_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static final String DRIVER_PATH = "postgresql-42.7.5.jar";

    static {
        try {
            File driverFile = new File(DRIVER_PATH);
            if (driverFile.exists()) {
                java.net.URLClassLoader classLoader = new java.net.URLClassLoader(
                    new java.net.URL[]{driverFile.toURI().toURL()},
                    DatabaseConnection.class.getClassLoader()
                );
                Class.forName("org.postgresql.Driver", true, classLoader);
            } else {
                System.err.println("Драйвер не найден по пути: " + DRIVER_PATH);
            }
        } catch (Exception e) {
            System.err.println("Ошибка загрузки драйвера PostgreSQL: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
} 