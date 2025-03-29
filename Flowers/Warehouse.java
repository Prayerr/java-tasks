import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Flower, Integer> flowerStock;
    private Map<Bouquet, Integer> bouquetStock;

    public Warehouse() {
        this.flowerStock = new HashMap<>();
        this.bouquetStock = new HashMap<>();
    }

    public void addFlower(Flower flower, int quantity) {
        flowerStock.merge(flower, quantity, Integer::sum);
    }

    public void addBouquet(Bouquet bouquet, int quantity) {
        bouquetStock.merge(bouquet, quantity, Integer::sum);
    }

    public boolean removeFlower(Flower flower, int quantity) {
        Integer currentQuantity = flowerStock.get(flower);
        if (currentQuantity != null && currentQuantity >= quantity) {
            flowerStock.put(flower, currentQuantity - quantity);
            return true;
        }
        return false;
    }

    public boolean removeBouquet(Bouquet bouquet, int quantity) {
        Integer currentQuantity = bouquetStock.get(bouquet);
        if (currentQuantity != null && currentQuantity >= quantity) {
            bouquetStock.put(bouquet, currentQuantity - quantity);
            return true;
        }
        return false;
    }

    public int getFlowerQuantity(Flower flower) {
        return flowerStock.getOrDefault(flower, 0);
    }

    public int getBouquetQuantity(Bouquet bouquet) {
        return bouquetStock.getOrDefault(bouquet, 0);
    }

    public Map<Flower, Integer> getFlowerStock() {
        return new HashMap<>(flowerStock);
    }

    public Map<Bouquet, Integer> getBouquetStock() {
        return new HashMap<>(bouquetStock);
    }
} 