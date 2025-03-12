package Abstract;

public class Dog extends Pet {
    public Dog(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " гавкает");
    }

    public void bringSlippers() {
        System.out.println(getName() + " вертит хвостом");
    }
}
