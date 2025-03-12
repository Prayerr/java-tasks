package Abstract;

public class Spider extends Pet {
    public Spider(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " ничего не говорит");
    }
}
