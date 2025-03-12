package CatsAndMice;

public class App {
    public static void main(String[] args) {
        Mouse mouse1 = new Mouse(5.0);
        Mouse mouse2 = new Mouse(7.0);
        Mouse mouse3 = new Mouse(3.0);

        Cat cat1 = new Cat("Тузик", 6.0, 4.5);
        Cat cat2 = new Cat("Борис", 8.0, 5.0);

        cat1.catchMouse(mouse1);
        cat1.catchMouse(mouse2);
        cat2.catchMouse(mouse2);
        cat2.catchMouse(mouse3);

        System.out.println(cat1);
        System.out.println(cat2);

        cat1.attackCat(cat2);
        cat2.attackCat(cat1);
    }
}
