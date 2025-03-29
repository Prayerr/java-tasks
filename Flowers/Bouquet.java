import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private String name;
    private int maxFlowers;
    private List<Flower> flowers;
    private double totalPrice;

    public Bouquet(String name, int maxFlowers) {
        this.name = name;
        this.maxFlowers = maxFlowers;
        this.flowers = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addFlower(Flower flower) {
        if (flowers.size() < maxFlowers) {
            flowers.add(flower);
            totalPrice += flower.getPrice();
        } else {
            throw new IllegalStateException("Букет уже содержит максимальное количество цветов");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxFlowers() {
        return maxFlowers;
    }

    public void setMaxFlowers(int maxFlowers) {
        this.maxFlowers = maxFlowers;
    }

    public List<Flower> getFlowers() {
        return new ArrayList<>(flowers);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "name='" + name + '\'' +
                ", maxFlowers=" + maxFlowers +
                ", flowers=" + flowers +
                ", totalPrice=" + totalPrice +
                '}';
    }
} 