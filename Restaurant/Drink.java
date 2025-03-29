package Restaurant;

public class Drink {
    private String name;
    private int calories;
    private boolean isAlcoholic;
    private double price;

    public Drink(String name, int calories, boolean isAlcoholic, double price) {
        this.name = name;
        this.calories = calories;
        this.isAlcoholic = isAlcoholic;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s (Калории: %d, %s) - %.2f ₽",
                name, calories, isAlcoholic ? "Алкогольный" : "Безалкогольный", price);
    }
} 