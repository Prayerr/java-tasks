package Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Restaurant> restaurants;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRestaurants();
        
        while (true) {
            System.out.println("\n=== Ресторанная сеть ===");
            System.out.println("1. Показать меню ресторана");
            System.out.println("2. Сделать заказ");
            System.out.println("3. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showRestaurantMenu();
                    break;
                case 2:
                    makeOrder();
                    break;
                case 3:
                    System.out.println("Спасибо за посещение!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void initializeRestaurants() {
        restaurants = new ArrayList<>();
        
        Restaurant moscow1 = new Restaurant("Московский 1", "Москва");
        Restaurant moscow2 = new Restaurant("Московский 2", "Москва");
        Restaurant moscow3 = new Restaurant("Московский 3", "Москва");
        
        Restaurant spb1 = new Restaurant("Петербургский 1", "Санкт-Петербург");
        Restaurant spb2 = new Restaurant("Петербургский 2", "Санкт-Петербург");

        addMenuItems(moscow1);
        addMenuItems(moscow2);
        addMenuItems(moscow3);
        addMenuItems(spb1);
        addMenuItems(spb2);

        restaurants.add(moscow1);
        restaurants.add(moscow2);
        restaurants.add(moscow3);
        restaurants.add(spb1);
        restaurants.add(spb2);
    }

    private static void addMenuItems(Restaurant restaurant) {
        restaurant.addDish(new Dish("Стейк Рибай", false, 800, DishType.MEAT, 1500));
        restaurant.addDish(new Dish("Лосось на гриле", false, 600, DishType.FISH, 1200));
        restaurant.addDish(new Dish("Паста Карбонара", false, 700, DishType.OTHER, 800));
        restaurant.addDish(new Dish("Салат Цезарь", true, 300, DishType.OTHER, 500));
        
        restaurant.addDrink(new Drink("Кола", 140, false, 150));
        restaurant.addDrink(new Drink("Вино", 120, true, 400));
        
        restaurant.setChefSpecial(new Dish("Фирменное блюдо шефа", false, 900, DishType.MEAT, 2000));
    }

    private static void showRestaurantMenu() {
        System.out.println("\nВыберите ресторан:");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName() + " (" + restaurants.get(i).getCity() + ")");
        }
        
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= restaurants.size()) {
            restaurants.get(choice - 1).displayMenu();
        } else {
            System.out.println("Неверный выбор ресторана.");
        }
    }

    private static void makeOrder() {
        System.out.println("\nВыберите ресторан:");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName() + " (" + restaurants.get(i).getCity() + ")");
        }
        
        int restaurantChoice = scanner.nextInt();
        if (restaurantChoice <= 0 || restaurantChoice > restaurants.size()) {
            System.out.println("Неверный выбор ресторана.");
            return;
        }

        Restaurant selectedRestaurant = restaurants.get(restaurantChoice - 1);
        List<Dish> selectedDishes = new ArrayList<>();
        List<Drink> selectedDrinks = new ArrayList<>();

        System.out.println("\nВыберите блюда (введите номера через пробел, 0 для завершения):");
        selectedRestaurant.getDishes().forEach(dish -> System.out.println(dish));
        
        while (true) {
            int dishChoice = scanner.nextInt();
            if (dishChoice == 0) break;
            if (dishChoice > 0 && dishChoice <= selectedRestaurant.getDishes().size()) {
                selectedDishes.add(selectedRestaurant.getDishes().get(dishChoice - 1));
            }
        }

        System.out.println("\nВыберите напитки (введите номера через пробел, 0 для завершения):");
        selectedRestaurant.getDrinks().forEach(drink -> System.out.println(drink));
        
        while (true) {
            int drinkChoice = scanner.nextInt();
            if (drinkChoice == 0) break;
            if (drinkChoice > 0 && drinkChoice <= selectedRestaurant.getDrinks().size()) {
                selectedDrinks.add(selectedRestaurant.getDrinks().get(drinkChoice - 1));
            }
        }

        double total = selectedRestaurant.calculateTotal(selectedDishes, selectedDrinks);
        System.out.printf("\nИтоговая сумма заказа: %.2f ₽\n", total);
    }
} 