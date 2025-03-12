package Employees;

import java.util.*;

public class Main {
    private static final String[] names = {"Алексей", "Мария", "Иван", "Ольга", "Дмитрий", "Анна", "Сергей", "Елена", "Николай", "Татьяна"};
    private static final String[] companies = {"Google", "Yandex", "Apple", "Microsoft", "Amazon", "Facebook", "Sber"};

    public static void main(String[] args) {
        List<Employee> employees = generateRandomEmployees();

        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Сортировка по имени");
        employees.forEach(System.out::println);

        employees.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        System.out.println("\nСортировка по имени и зарплате");
        employees.forEach(System.out::println);

        employees.sort(Comparator
                .comparing(Employee::getName)
                .thenComparing(Employee::getSalary)
                .thenComparing(Employee::getAge)
                .thenComparing(Employee::getCompany));
        System.out.println("\nСортировка по имени, зарплате, возрасту и компании");
        employees.forEach(System.out::println);
    }

    private static List<Employee> generateRandomEmployees() {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i+=1) {
            String name = names[random.nextInt(names.length)];
            String company = companies[random.nextInt(companies.length)];
            int salary = random.nextInt(100000) + 30000;
            int age = random.nextInt(40) + 21;
            employees.add(new Employee(name, company, salary, age));
        }

        return employees;
    }
}