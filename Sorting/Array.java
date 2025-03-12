package Sorting;

import java.util.Arrays;

class Array {
    private int[] data;

    public Array(int size) {
        data = new int[size];
    }

    public void insert(int index, int value) {
        if (index >= 0 && index < data.length) {
            data[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Индекс за границами массива");
        }
    }

    public void display() {
        System.out.println(Arrays.toString(data));
    }

    public void bubbleSort() {
        int n = data.length;
        for (int i = 0; i < n - 1; i+=1) {
            for (int j = 0; j < n - i - 1; j+=1) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void selectionSort() {
        int n = data.length;
        for (int i = 0; i < n - 1; i+=1) {
            int minIndex = i;
            for (int j = i + 1; j < n; j+=1) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }

    public void insertionSort() {
        int n = data.length;
        for (int i = 1; i < n; i+=1) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j-=1;
            }
            data[j + 1] = key;
        }
    }
}
