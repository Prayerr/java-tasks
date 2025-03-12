package Products;

public class Product {
    private String name;
    private double proteins;
    private double fats;
    private double carbs;
    private double calories;

    public Product(String name, double proteins, double fats, double carbs, double calories) {
        setName(name);
        setProteins(proteins);
        setFats(fats);
        setCarbs(carbs);
        setCalories(calories);
    }

    public Product(String name, double proteins, double fats, double carbs) {
        this(name, proteins, fats, carbs, calculateCalories(proteins, fats, carbs));
    }

    public Product(String name, double calories) {
        this(name, 0, 0, 0, calories);
    }

    public Product(Product other) {
        this(other.name, other.proteins, other.fats, other.carbs, other.calories);
    }

    private static double calculateCalories(double proteins, double fats, double carbs) {
        return (proteins * 4) + (fats * 9) + (carbs * 4);
    }

    public String getName() {
        return name;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFats() {
        return fats;
    }

    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.name = name;
    }

    public void setProteins(double proteins) {
        if (proteins < 0) {
            throw new IllegalArgumentException("Количество белков не может быть отрицательным");
        }
        this.proteins = proteins;
    }

    public void setFats(double fats) {
        if (fats < 0) {
            throw new IllegalArgumentException("Количество жиров не может быть отрицательным");
        }
        this.fats = fats;
    }

    public void setCarbs(double carbs) {
        if (carbs < 0) {
            throw new IllegalArgumentException("Количество углеводов не может быть отрицательным");
        }
        this.carbs = carbs;
    }

    public void setCalories(double calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Количество калорий не может быть отрицательным");
        }
        this.calories = calories;
    }

    @Override
    public String toString() {
        return String.format("%s: Белки=%.2f г, Жиры=%.2f г, Углеводы=%.2f г, Калории=%.2f ккал", name, proteins, fats, carbs, calories);
    }
}