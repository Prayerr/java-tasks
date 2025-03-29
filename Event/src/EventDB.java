import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/event_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка загрузки драйвера PostgreSQL: " + e.getMessage());
        }
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS events (" +
                "id SERIAL PRIMARY KEY," +
                "title VARCHAR(255) NOT NULL," +
                "description TEXT NOT NULL," +
                "event_date TIMESTAMP NOT NULL," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица events успешно создана");
        } catch (SQLException e) {
            System.err.println("Ошибка создания таблицы: " + e.getMessage());
        }
    }

    public static void addEvent(String title, String description, Timestamp date) {
        String sql = "INSERT INTO events (title, description, event_date) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setTimestamp(3, date);
            pstmt.executeUpdate();
            System.out.println("Событие успешно добавлено");
        } catch (SQLException e) {
            System.err.println("Ошибка добавления события: " + e.getMessage());
        }
    }

    public static List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events ORDER BY event_date";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Event event = new Event();
                event.setId(rs.getLong("id"));
                event.setTitle(rs.getString("title"));
                event.setDescription(rs.getString("description"));
                event.setDate(rs.getTimestamp("event_date"));
                event.setCreatedAt(rs.getTimestamp("created_at"));
                events.add(event);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка получения событий: " + e.getMessage());
        }
        return events;
    }

    public static void updateEvent(long id, String title, String description, Timestamp date) {
        String sql = "UPDATE events SET title = ?, description = ?, event_date = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setTimestamp(3, date);
            pstmt.setLong(4, id);
            pstmt.executeUpdate();
            System.out.println("Событие успешно обновлено");
        } catch (SQLException e) {
            System.err.println("Ошибка обновления события: " + e.getMessage());
        }
    }

    public static void deleteEvent(long id) {
        String sql = "DELETE FROM events WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            System.out.println("Событие успешно удалено");
        } catch (SQLException e) {
            System.err.println("Ошибка удаления события: " + e.getMessage());
        }
    }

    public static Event getEventById(long id) {
        String sql = "SELECT * FROM events WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Event event = new Event();
                    event.setId(rs.getLong("id"));
                    event.setTitle(rs.getString("title"));
                    event.setDescription(rs.getString("description"));
                    event.setDate(rs.getTimestamp("event_date"));
                    event.setCreatedAt(rs.getTimestamp("created_at"));
                    return event;
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка получения события: " + e.getMessage());
        }
        return null;
    }
} 