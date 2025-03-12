package Abstract;

public class Fish extends Pet {
    public Fish(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " ничего не говорит");
    }
}