package Array;

import java.util.Random;

public class ArrayManager {
    private int[] array;

    public ArrayManager(int size) {
        array = new int[size];
    }

    public void fillArray() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(101);
        }
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public boolean findElement(int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void deleteElement(int index) {
        if (index < 0 || index >= array.length) {
            System.out.println("Индекс за пределами массива");
            return;
        }
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
    }

    public void insertElement(int index, int value) {
        if (index < 0 || index >= array.length) {
            System.out.println("Индекс за пределами массива");
            return;
        }
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }
}