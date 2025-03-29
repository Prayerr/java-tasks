package Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Company company = new Company();
        
        List<Employee> employees = new ArrayList<>();
        
        for (int i = 0; i < 120; i++) {
            employees.add(new Operator(
                "Оператор " + (i + 1),
                random.nextInt(16) + 25,
                random.nextInt(101_000) + 100_000
            ));
        }
        
        for (int i = 0; i < 10; i++) {
            employees.add(new TopManager(
                "Топ-менеджер " + (i + 1),
                random.nextInt(16) + 25,
                random.nextInt(101_000) + 100_000
            ));
        }
        
        for (int i = 0; i < 50; i++) {
            employees.add(new Programmer(
                "Программист " + (i + 1),
                random.nextInt(16) + 25,
                random.nextInt(101_000) + 100_000
            ));
        }
        
        company.hireAll(employees);
        
        System.out.println("Топ-15 самых высоких зарплат:");
        company.getTopSalaryStaff(15).forEach(employee ->
            System.out.printf("%s: %.2f руб.%n", employee.getFullName(), employee.getTotalSalary()));
        
        System.out.println("\n30 самых низких зарплат:");
        company.getLowestSalaryStaff(30).forEach(employee ->
            System.out.printf("%s: %.2f руб.%n", employee.getFullName(), employee.getTotalSalary()));
        
        List<Employee> allEmployees = company.getEmployees();
        int halfSize = allEmployees.size() / 2;
        for (int i = 0; i < halfSize; i++) {
            company.fire(allEmployees.get(i));
        }
        
        System.out.println("\nТоп-15 самых высоких зарплат после увольнений:");
        company.getTopSalaryStaff(15).forEach(employee ->
            System.out.printf("%s: %.2f руб.%n", employee.getFullName(), employee.getTotalSalary()));
        
        System.out.println("\n30 самых низких зарплат после увольнений:");
        company.getLowestSalaryStaff(30).forEach(employee ->
            System.out.printf("%s: %.2f руб.%n", employee.getFullName(), employee.getTotalSalary()));
    }
} 