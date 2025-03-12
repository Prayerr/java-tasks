package Message;

import java.util.*;

public class MessageGenerator {
    private static final Random random = new Random();

    public static List<Message> generateMessages(int count) {
        List<Message> messages = new ArrayList<>();
        String[] sampleTexts = { "Проверка связи", "Срочное сообщение", "Обновление системы", "Ошибка 404", "Уведомление", "Внимание", "Тестовое сообщение", "Важная информация" };

        for (int i = 0; i < count; i++) {
            Message.Priority priority = Message.Priority.values()[random.nextInt(Message.Priority.values().length)];
            int code = 100 + random.nextInt(900);
            String text = sampleTexts[random.nextInt(sampleTexts.length)];
            messages.add(new Message(priority, code, text));
        }

        return messages;
    }
}
