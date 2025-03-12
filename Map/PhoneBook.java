package Map;

import java.util.*;

public class PhoneBook {
    private Map<String, String> nameToPhone;
    private Map<String, String> phoneToName;

    public PhoneBook() {
        nameToPhone = new HashMap<>();
        phoneToName = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        nameToPhone.put(name, phone);
        phoneToName.put(phone, name);
        System.out.println("Контакт добавлен: " + name + " - " + phone);
    }

    public void findByName(String name) {
        if (nameToPhone.containsKey(name)) {
            System.out.println("Найден контакт: " + name + " - " + nameToPhone.get(name));
        } else {
            System.out.println("Контакт с именем '" + name + "' не найден");
        }
    }

    public void findByPhone(String phone) {
        if (phoneToName.containsKey(phone)) {
            System.out.println("Найден контакт: " + phoneToName.get(phone) + " - " + phone);
        } else {
            System.out.println("Контакт с номером '" + phone + "' не найден");
        }
    }

    public void listAllContacts() {
        if (nameToPhone.isEmpty()) {
            System.out.println("Телефонная книга пуста");
        } else {
            System.out.println("Список всех контактов:");
            nameToPhone.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        }
    }
}
