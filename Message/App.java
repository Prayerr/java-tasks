package Message;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Message> messages = MessageGenerator.generateMessages(20);
        System.out.println("Исходный список сообщений");
        messages.forEach(System.out::println);

        List<Message> uniqueMessages = getUniqueMessages(messages);
        System.out.println("\nУникальные сообщения");
        uniqueMessages.forEach(System.out::println);

        Message.Priority priorityToRemove = Message.Priority.medium;
        System.out.println("\nДо удаления сообщений с приоритетом " + priorityToRemove);
        messages.forEach(System.out::println);
        removeMessagesByPriority(messages, priorityToRemove);
        System.out.println("\nПосле удаления сообщений с приоритетом " + priorityToRemove);
        messages.forEach(System.out::println);

        Message.Priority priorityToKeep = Message.Priority.high;
        System.out.println("\nДо удаления всех сообщений кроме приоритета " + priorityToKeep);
        messages.forEach(System.out::println);
        keepOnlyMessagesWithPriority(messages, priorityToKeep);
        System.out.println("\nПосле удаления всех сообщений кроме приоритета " + priorityToKeep);
        messages.forEach(System.out::println);

        Map<Message.Priority, Long> priorityCounts = countMessagesByPriority(messages);
        System.out.println("\nКоличество сообщений по приоритетам");
        priorityCounts.forEach((priority, count) -> System.out.println(priority + ": " + count));

        Map<Integer, Long> codeCounts = countMessagesByCode(messages);
        System.out.println("\nКоличество сообщений по кодам");
        codeCounts.forEach((code, count) -> System.out.println("Код " + code + ": " + count));

        int uniqueCount = (int) countUniqueMessages(messages);
        System.out.println("\nКоличество уникальных сообщений: " + uniqueCount);
    }

    private static List<Message> getUniqueMessages(List<Message> messages) {
        return messages.stream().distinct().collect(Collectors.toList());
    }

    private static void removeMessagesByPriority(List<Message> messages, Message.Priority priority) {
        messages.removeIf(message -> message.getPriority() == priority);
    }

    private static void keepOnlyMessagesWithPriority(List<Message> messages, Message.Priority priority) {
        messages.removeIf(message -> message.getPriority() != priority);
    }

    private static Map<Message.Priority, Long> countMessagesByPriority(List<Message> messages) {
        return messages.stream().collect(Collectors.groupingBy(Message::getPriority, Collectors.counting()));
    }

    private static Map<Integer, Long> countMessagesByCode(List<Message> messages) {
        return messages.stream().collect(Collectors.groupingBy(Message::getCode, Collectors.counting()));
    }

    private static long countUniqueMessages(List<Message> messages) {
        return messages.stream().distinct().count();
    }
}
