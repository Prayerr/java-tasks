package Sorting;

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }
}

class PersonArray {
    private Person[] people;

    public PersonArray(int size) {
        people = new Person[size];
    }

    public void insert(int index, Person person) {
        if (index >= 0 && index < people.length) {
            people[index] = person;
        } else {
            throw new IndexOutOfBoundsException("Индкс за пределами массива");
        }
    }

    public void display() {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public void bubbleSortByAge() {
        int n = people.length;
        for (int i = 0; i < n - 1; i+=1) {
            for (int j = 0; j < n - i - 1; j+=1) {
                if (people[j].getAge() > people[j + 1].getAge()) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    public void selectionSortByLastName() {
        int n = people.length;
        for (int i = 0; i < n - 1; i+=1) {
            int minIndex = i;
            for (int j = i + 1; j < n; j+=1) {
                if (people[j].getLastName().compareTo(people[minIndex].getLastName()) < 0) {
                    minIndex = j;
                }
            }
            Person temp = people[minIndex];
            people[minIndex] = people[i];
            people[i] = temp;
        }
    }

    public void insertionSortByFirstName() {
        int n = people.length;
        for (int i = 1; i < n; i+=1) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getFirstName().compareTo(key.getFirstName()) > 0) {
                people[j + 1] = people[j];
                j-=1;
            }
            people[j + 1] = key;
        }
    }
}