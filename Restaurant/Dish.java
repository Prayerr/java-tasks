package Restaurant;

public class Dish {
    private String name;
    private boolean isVegetarian;
    private int calories;
    private DishType type;
    private double price;

    public Dish(String name, boolean isVegetarian, int calories, DishType type, double price) {
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.calories = calories;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public DishType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s (Калории: %d, %s, %s) - %.2f ₽",
                name, calories, isVegetarian ? "Вегетарианское" : "Не вегетарианское",
                type.getDescription(), price);
    }
} 