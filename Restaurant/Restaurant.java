package Restaurant;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String city;
    private List<Dish> dishes;
    private List<Drink> drinks;
    private Dish chefSpecial;
    private boolean isMoscow;

    public Restaurant(String name, String city) {
        this.name = name;
        this.city = city;
        this.dishes = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.isMoscow = city.equals("Москва");
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void setChefSpecial(Dish chefSpecial) {
        this.chefSpecial = chefSpecial;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public Dish getChefSpecial() {
        return chefSpecial;
    }

    public boolean isMoscow() {
        return isMoscow;
    }

    public void displayMenu() {
        LocalTime currentTime = LocalTime.now();
        System.out.println("\n=== Меню ресторана " + name + " (" + city + ") ===");
        
        if (currentTime.isAfter(LocalTime.of(7, 0)) && currentTime.isBefore(LocalTime.of(11, 0))) {
            System.out.println("\nУтреннее меню:");
            dishes.stream()
                .filter(dish -> dish.getType() == DishType.OTHER)
                .forEach(System.out::println);
        }
        else if (currentTime.isAfter(LocalTime.of(12, 0)) && currentTime.isBefore(LocalTime.of(15, 0))) {
            System.out.println("\nБизнес-ланч:");
            dishes.stream()
                .filter(dish -> dish.getType() != DishType.OTHER)
                .forEach(System.out::println);
        }
        else {
            System.out.println("\nОсновное меню:");
            dishes.forEach(System.out::println);
        }

        System.out.println("\nНапитки:");
        drinks.forEach(System.out::println);

        if (chefSpecial != null) {
            System.out.println("\nБлюдо от шефа:");
            System.out.println(chefSpecial);
        }
    }

    public double calculateTotal(List<Dish> selectedDishes, List<Drink> selectedDrinks) {
        LocalTime currentTime = LocalTime.now();
        boolean isDiscountTime = currentTime.isAfter(LocalTime.of(15, 0)) && 
                               currentTime.isBefore(LocalTime.of(18, 0)) &&
                               java.time.DayOfWeek.from(java.time.LocalDate.now()).getValue() <= 5;

        double total = 0;
        
        for (Dish dish : selectedDishes) {
            double price = dish.getPrice();
            if (isMoscow) {
                price *= 1.1;
            }
            if (isDiscountTime) {
                price *= 0.8;
            }
            total += price;
        }

        for (Drink drink : selectedDrinks) {
            double price = drink.getPrice();
            if (isMoscow) {
                price *= 1.1;
            }
            total += price;
        }

        return total;
    }
} 