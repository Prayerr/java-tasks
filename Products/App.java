package Products;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 0.3, 0.2, 14);
        Product chicken = new Product("Курица", 27, 3.5, 0);
        Product chocolate = new Product("Шоколад", 5, 35, 55);
        Product bread = new Product("Хлеб", 8, 1, 50);
        Product milk = new Product("Молоко", 3.3, 3.6, 4.7);
        Product cheese = new Product("Сыр", 25, 33, 1.3);

        MyProducts myProducts = new MyProducts(30, 20, 100, 500);

        myProducts.addProduct(apple);
        myProducts.addProduct(chicken);
        myProducts.addProduct(chocolate);
        myProducts.addProduct(bread);
        myProducts.addProduct(milk);
        myProducts.addProduct(cheese);

        myProducts.printProducts();
    }
}
