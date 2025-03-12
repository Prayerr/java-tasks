package Abstract;

public abstract class Pet {
    private String name;
    private double weight;

    public Pet(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract void makeSound();

    public void sleep() {
        System.out.println(name + " спит");
    }

    public void play() {
        System.out.println(name + " играет");
    }

    @Override
    public String toString() {
        return name + " вес: " + weight + " кг";
    }
}
