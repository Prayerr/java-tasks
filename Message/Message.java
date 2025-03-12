package Message;

public class Message {
    public enum Priority {
        low, medium, high, urgent
    }

    private Priority priority;
    private int code;
    private String text;

    public Message(Priority priority, int code, String text) {
        this.priority = priority;
        this.code = code;
        this.text = text;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Приоритет: " + priority + ", код: " + code + ", текст: " + text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Message message = (Message) obj;
        return code == message.code && text.equals(message.text);
    }

    @Override
    public int hashCode() {
        return code + text.hashCode();
    }
}
