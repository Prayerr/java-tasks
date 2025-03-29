import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class EventManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        EventDB.createTable();

        while (true) {
            System.out.println("\n=== Меню управления событиями ===");
            System.out.println("1. Добавить событие");
            System.out.println("2. Показать все события");
            System.out.println("3. Редактировать событие");
            System.out.println("4. Удалить событие");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    showAllEvents();
                    break;
                case 3:
                    editEvent();
                    break;
                case 4:
                    deleteEvent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void addEvent() {
        System.out.print("Введите заголовок события: ");
        String title = scanner.nextLine();
        
        System.out.print("Введите описание события: ");
        String description = scanner.nextLine();
        
        System.out.print("Введите дату и время (формат: yyyy-MM-dd HH:mm): ");
        String dateStr = scanner.nextLine();
        
        try {
            Timestamp date = new Timestamp(dateFormat.parse(dateStr).getTime());
            EventDB.addEvent(title, description, date);
        } catch (ParseException e) {
            System.out.println("Ошибка формата даты. Используйте формат: yyyy-MM-dd HH:mm");
        }
    }

    private static void showAllEvents() {
        List<Event> events = EventDB.getAllEvents();
        if (events.isEmpty()) {
            System.out.println("Событий не найдено.");
            return;
        }

        System.out.println("\nСписок событий:");
        for (Event event : events) {
            System.out.printf("ID: %d\nЗаголовок: %s\nОписание: %s\nДата: %s\n\n",
                    event.getId(),
                    event.getTitle(),
                    event.getDescription(),
                    event.getDate());
        }
    }

    private static void editEvent() {
        System.out.print("Введите ID события для редактирования: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Event event = EventDB.getEventById(id);
        if (event == null) {
            System.out.println("Событие не найдено.");
            return;
        }

        System.out.print("Введите новый заголовок (или нажмите Enter для пропуска): ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) {
            event.setTitle(title);
        }

        System.out.print("Введите новое описание (или нажмите Enter для пропуска): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            event.setDescription(description);
        }

        System.out.print("Введите новую дату и время (формат: yyyy-MM-dd HH:mm) или нажмите Enter для пропуска: ");
        String dateStr = scanner.nextLine();
        if (!dateStr.isEmpty()) {
            try {
                Timestamp date = new Timestamp(dateFormat.parse(dateStr).getTime());
                event.setDate(date);
            } catch (ParseException e) {
                System.out.println("Ошибка формата даты. Изменения даты не сохранены.");
            }
        }

        EventDB.updateEvent(event.getId(), event.getTitle(), event.getDescription(), event.getDate());
    }

    private static void deleteEvent() {
        System.out.print("Введите ID события для удаления: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Event event = EventDB.getEventById(id);
        if (event == null) {
            System.out.println("Событие не найдено.");
            return;
        }

        EventDB.deleteEvent(id);
    }
} 