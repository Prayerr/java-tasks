package Phone;

import java.util.*;

public class Main {
    private static final String[] phoneModels = {"IPhone 17", "Samsung Galaxy S23", "Xiaomi", "Google Pixel 8", "OnePlus"};
    private static final Random random = new Random();

    public static void main(String[] args) {
        int phoneCounts = 30;

        List<Phone> phones = generateRandomPhones(phoneCounts);

        System.out.println("Все");
        phones.forEach(System.out::println);

        phones.sort(Comparator.comparingDouble(p -> p.price));
        System.out.println("\nТелефоны отсортированные по цене");
        phones.forEach(System.out::println);

        phones.sort(Comparator.comparingDouble(p -> p.weight));
        System.out.println("\nТелефоны отсортированные по весу");
        phones.forEach(System.out::println);
    }

    private static List<Phone> generateRandomPhones(int count) {
        List<Phone> phones = new ArrayList<>();

        for (int i = 0; i < count; i+=1) {
            double weight = 0.1 + (0.4 * random.nextDouble());
            double price = 20000 + (84000 * random.nextDouble());
            String serialNumber = "SER" + (1000 + i);
            String model = phoneModels[random.nextInt(phoneModels.length)];

            phones.add(new Phone(serialNumber, model, weight, price));
        }

        return phones;
    }
}