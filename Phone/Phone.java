package Phone;

class Phone {
    public String serialNumber;
    public String model;
    public double weight;
    public double price;

    public Phone(String serialNumber, String model, double weight, double price) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Серийный номер: " + serialNumber + ", Модель: " + model +  ", Вес: " + String.format("%.2f", weight) + " кг" + ", Цена: " + String.format("%.2f", price) + " руб.";
    }
}
