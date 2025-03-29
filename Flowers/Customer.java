import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private List<Order> orderHistory;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.orderHistory = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrderHistory() {
        return new ArrayList<>(orderHistory);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", orderHistorySize=" + orderHistory.size() +
                '}';
    }
} 