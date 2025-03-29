public class App {
    public static void main(String[] args) {
        FlowerShop shop = new FlowerShop("Цветочный рай");

        Flower rose = new Flower("Роза", 150.0, 4.8);
        Flower tulip = new Flower("Тюльпан", 100.0, 4.5);
        Flower lily = new Flower("Лилия", 200.0, 4.7);

        shop.addFlowerToWarehouse(rose, 50);
        shop.addFlowerToWarehouse(tulip, 100);
        shop.addFlowerToWarehouse(lily, 30);

        Bouquet springBouquet = new Bouquet("Весенний букет", 5);
        springBouquet.addFlower(rose);
        springBouquet.addFlower(tulip);
        springBouquet.addFlower(lily);

        shop.addBouquetToWarehouse(springBouquet, 10);

        Customer customer = new Customer("Иван Иванов", "ivan@example.com", "+7-999-123-45-67");
        shop.addCustomer(customer);

        Order order = new Order("ORD-001", customer);
        order.addItem(new OrderItem("Весенний букет", springBouquet.getTotalPrice(), 1));
        order.setStatus(OrderStatus.PROCESSING);

        shop.addOrder(order);

        System.out.println("Информация о магазине:");
        System.out.println(shop);
        System.out.println("\nИнформация о складе:");
        System.out.println(shop.getWarehouse());
        System.out.println("\nИнформация о заказе:");
        System.out.println(order);
    }
} 