package Restaurant;

public enum DishType {
    MEAT("Мясо"),
    FISH("Рыба"),
    OTHER("Другое");

    private final String description;

    DishType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
} 