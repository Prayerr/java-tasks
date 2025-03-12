package Abstract;

public class Hamster extends Pet {
    public Hamster(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " пи-пи-пи");
    }

    public void hideFood() {
        System.out.println(getName() + " спрятал еду");
    }
}
