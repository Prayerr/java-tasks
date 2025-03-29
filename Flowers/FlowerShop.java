import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowerShop {
    private String name;
    private Warehouse warehouse;
    private Map<String, Customer> customers;
    private List<Order> orders;

    public FlowerShop(String name) {
        this.name = name;
        this.warehouse = new Warehouse();
        this.customers = new HashMap<>();
        this.orders = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getEmail(), customer);
    }

    public Customer getCustomer(String email) {
        return customers.get(email);
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.getCustomer().addOrder(order);
    }

    public void addFlowerToWarehouse(Flower flower, int quantity) {
        warehouse.addFlower(flower, quantity);
    }

    public void addBouquetToWarehouse(Bouquet bouquet, int quantity) {
        warehouse.addBouquet(bouquet, quantity);
    }

    public boolean removeFlowerFromWarehouse(Flower flower, int quantity) {
        return warehouse.removeFlower(flower, quantity);
    }

    public boolean removeBouquetFromWarehouse(Bouquet bouquet, int quantity) {
        return warehouse.removeBouquet(bouquet, quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Map<String, Customer> getCustomers() {
        return new HashMap<>(customers);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public String toString() {
        return "FlowerShop{" +
                "name='" + name + '\'' +
                ", warehouse=" + warehouse +
                ", customers=" + customers +
                ", orders=" + orders +
                '}';
    }
} 