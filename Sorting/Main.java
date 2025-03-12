package Sorting;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array(5);
        arr.insert(0, 64);
        arr.insert(1, 34);
        arr.insert(2, 25);
        arr.insert(3, 12);
        arr.insert(4, 22);

        System.out.println("Массив:");
        arr.display();

        arr.bubbleSort();
        System.out.println("после пузырьковой сортировки:");
        arr.display();

        arr.selectionSort();
        System.out.println("После сортировки методом выбора:");
        arr.display();

        arr.insertionSort();
        System.out.println("После сортировки методом вставки:");
        arr.display();

        PersonArray personArr = new PersonArray(4);
        personArr.insert(0, new Person("Иван", "Иванов", 30));
        personArr.insert(1, new Person("Петр", "Петров", 22));
        personArr.insert(2, new Person("Сергей", "Сергеевич", 40));
        personArr.insert(3, new Person("Андрей", "Андреевич", 25));

        System.out.println("\nМассив Person:");
        personArr.display();

        personArr.bubbleSortByAge();
        System.out.println("\n После сортировки пузырьком по возрасту");
        personArr.display();

        personArr.selectionSortByLastName();
        System.out.println("\n После сортировки методом выбора по фамилии");
        personArr.display();

        personArr.insertionSortByFirstName();
        System.out.println("\n После сортировки методом вставки по имени");
        personArr.display();
    }
}
