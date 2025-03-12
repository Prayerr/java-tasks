package Abstract;

public class Cat extends Pet {
    public Cat(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " мяукает");
    }

    public void catchMouse() {
        System.out.println(getName() + " поймал мышь");
    }
}
