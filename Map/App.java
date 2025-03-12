package Map;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступные команды: add, find, list, E (Выйти)");

        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("E")) {
                System.out.println("Выход из программы");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                phoneBook.listAllContacts();
            } else if (input.startsWith("add ")) {
                String data = input.substring(4).trim();
                if (data.matches("\\d+")) {
                    System.out.print("Введите имя ");
                    String name = scanner.nextLine().trim();
                    phoneBook.addContact(name, data);
                } else {
                    System.out.print("Введите номер телефона ");
                    String phone = scanner.nextLine().trim();
                    phoneBook.addContact(data, phone);
                }
            } else if (input.startsWith("find ")) {
                String data = input.substring(5).trim();
                if (data.matches("\\d+")) {
                    phoneBook.findByPhone(data);
                } else {
                    phoneBook.findByName(data);
                }
            } else {
                System.out.println("Неизвестная команда");
            }
        }

        scanner.close();
    }
}
