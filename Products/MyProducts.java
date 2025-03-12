package Products;

import java.util.*;;

public class MyProducts {
    private double maxProteins;
    private double maxFats;
    private double maxCarbs;
    private double maxCalories;
    private List<Product> products;

    public MyProducts(double maxProteins, double maxFats, double maxCarbs, double maxCalories) {
        this.maxProteins = maxProteins;
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxCalories = maxCalories;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product.getProteins() > maxProteins) {
            System.out.println("Продукт '" + product.getName() + "' не добавлен слишком много белков");
            return;
        }

        if (product.getFats() > maxFats) {
            System.out.println("Продукт '" + product.getName() + "' не добавлен слишком много жиров");
            return;
        }

        if (product.getCarbs() > maxCarbs) {
            System.out.println("Продукт '" + product.getName() + "' не добавлен слишком много углеводов");
            return;
        }

        if (product.getCalories() > maxCalories) {
            System.out.println("Продукт '" + product.getName() + "' не добавлен слишком много калорий");
            return;
        }

        products.add(product);

        System.out.println("Продукт '" + product.getName() + "' успешно добавлен");
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("Список продуктов пуст");
            return;
        }

        System.out.println("Список продуктов");

        for (Product product : products) {
            System.out.println(product);
        }
    }
}