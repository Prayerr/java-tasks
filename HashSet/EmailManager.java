package HashSet;

import java.util.*;

public class EmailManager {
    private Set<String> emails;

    public EmailManager() {
        emails = new HashSet<>();
    }

    public void addEmail(String email) {
        if (EmailValidator.isValidEmail(email)) {
            if (emails.add(email)) {
                System.out.println("Email добавлен " + email);
            } else {
                System.out.println("Email уже существует " + email);
            }
        } else {
            System.out.println("Ошибка, некорректный email адрес: " + email);
        }
    }

    public void listEmails() {
        if (emails.isEmpty()) {
            System.out.println("Список email адресов пуст");
        } else {
            System.out.println("Список email адресов");
            emails.forEach(System.out::println);
        }
    }
}
