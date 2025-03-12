package Array;

public class Main {
    public static void main(String[] args) {
        ArrayManager arrayManager = new ArrayManager(100);

        arrayManager.fillArray();
        arrayManager.printArray();

        System.out.println("Элемент 50 найден: " + arrayManager.findElement(50));

        arrayManager.deleteElement(10);
        arrayManager.insertElement(10, 99);

        arrayManager.printArray();

        PersonManager personManager = new PersonManager(10);

        personManager.addPerson(new Person("Иван", "Иванов", 30));
        personManager.addPerson(new Person("Петр", "Петров", 25));

        personManager.printPersons();
        Person foundPerson = personManager.findPerson("Иван", "Иванов");

        if (foundPerson != null) {
            System.out.println("Найден: " + foundPerson);
        }

        personManager.deletePerson("Иван", "Иванов");
        personManager.printPersons();
    }
}
