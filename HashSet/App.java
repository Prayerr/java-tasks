package HashSet;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EmailManager emailManager = new EmailManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступные команды: add, list, E (Выйти)");

        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("E")) {
                System.out.println("Выход из программы");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                emailManager.listEmails();
            } else if (input.startsWith("add ")) {
                String email = input.substring(4).trim();
                emailManager.addEmail(email);
            } else {
                System.out.println("Неизвестная команда");
            }
        }

        scanner.close();
    }
}
