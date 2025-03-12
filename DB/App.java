package DB;

public class App {
    public static void main(String[] args) {
        DatabaseManager.createTables();

        DataManager.addClient("Иван Иванов", "ivan@example.com", "1234567890");
        DataManager.addTour("Тур в Париж", "Экскурсия по Парижу", 500.0);
        DataManager.addBooking(1, 1, "2023-10-01");
        DataManager.addDestination("Париж", "Франция");
        DataManager.addPayment(1, 500.0, "2023-10-01");

        DataManager.printAllClients();

        DataManager.printClientsByName("Иван Иванов");

        DataManager.updateClient(1, "Иван Иванов", "ivan.new@example.com", "0987654321");

        DataManager.deleteClient(1);
    }
}
