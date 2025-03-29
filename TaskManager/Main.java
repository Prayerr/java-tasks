package taskmanager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Менеджер задач ===");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Просмотреть задачи на день");
            System.out.println("3. Просмотреть задачи на неделю");
            System.out.println("4. Показать историю просмотра");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasksForDay();
                    break;
                case 3:
                    viewTasksForWeek();
                    break;
                case 4:
                    showViewHistory();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Введите заголовок задачи: ");
        String title = scanner.nextLine();
        
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        
        System.out.print("Введите дату (дд.мм.гггг) или нажмите Enter для сегодняшней даты: ");
        String dateStr = scanner.nextLine();
        
        LocalDate date;
        if (dateStr.isEmpty()) {
            date = LocalDate.now();
        } else {
            try {
                date = LocalDate.parse(dateStr, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Используется сегодняшняя дата.");
                date = LocalDate.now();
            }
        }

        taskManager.addTask(title, description, date);
        System.out.println("Задача успешно добавлена!");
    }

    private static void viewTasksForDay() {
        System.out.print("Введите дату (дд.мм.гггг) или нажмите Enter для сегодняшней даты: ");
        String dateStr = scanner.nextLine();
        
        LocalDate date;
        if (dateStr.isEmpty()) {
            date = LocalDate.now();
        } else {
            try {
                date = LocalDate.parse(dateStr, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Используется сегодняшняя дата.");
                date = LocalDate.now();
            }
        }

        List<Task> tasks = taskManager.getTasksForDate(date);
        if (tasks.isEmpty()) {
            System.out.println("На эту дату задач не найдено.");
        } else {
            System.out.println("\nЗадачи на " + date.format(dateFormatter) + ":");
            for (Task task : tasks) {
                System.out.println("\n" + task);
                taskManager.addToHistory(task);
            }
        }
    }

    private static void viewTasksForWeek() {
        System.out.print("Введите начальную дату недели (дд.мм.гггг) или нажмите Enter для текущей недели: ");
        String dateStr = scanner.nextLine();
        
        LocalDate startDate;
        if (dateStr.isEmpty()) {
            startDate = LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 1);
        } else {
            try {
                startDate = LocalDate.parse(dateStr, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Используется текущая неделя.");
                startDate = LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 1);
            }
        }

        List<Task> tasks = taskManager.getTasksForWeek(startDate);
        if (tasks.isEmpty()) {
            System.out.println("На эту неделю задач не найдено.");
        } else {
            System.out.println("\nЗадачи на неделю с " + startDate.format(dateFormatter) + ":");
            for (Task task : tasks) {
                System.out.println("\n" + task);
                taskManager.addToHistory(task);
            }
        }
    }

    private static void showViewHistory() {
        List<Task> history = taskManager.getViewHistory();
        if (history.isEmpty()) {
            System.out.println("История просмотра пуста.");
        } else {
            System.out.println("\nПоследние просмотренные задачи:");
            for (Task task : history) {
                System.out.println("\n" + task);
            }
        }
    }
} 