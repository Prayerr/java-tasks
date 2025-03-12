package Array;

public class PersonManager {
    private Person[] persons;
    private int size;

    public PersonManager(int capacity) {
        persons = new Person[capacity];
        size = 0;
    }

    public void addPerson(Person person) {
        if (size < persons.length) {
            persons[size] = person;
            size+=1;
        } else {
            System.out.println("Массив полон");
        }
    }

    public Person findPerson(String firstName, String lastName) {
        for (int i = 0; i < size; i+=1) {
            if (persons[i].getFirstName().equals(firstName) && persons[i].getLastName().equals(lastName)) {
                return persons[i];
            }
        }
        return null;
    }

    public void deletePerson(String firstName, String lastName) {
        for (int i = 0; i < size; i+=1) {
            if (persons[i].getFirstName().equals(firstName) && persons[i].getLastName().equals(lastName)) {
                for (int j = i; j < size - 1; j+=1) {
                    persons[j] = persons[j + 1];
                }
                persons[size - 1] = null;
                size=-1;
                return;
            }
        }
        System.out.println("Человек не найден");
    }

    public void printPersons() {
        for (int i = 0; i < size; i+=1) {
            System.out.println(persons[i]);
        }
    }
}
