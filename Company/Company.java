package Company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Company {
    private List<Employee> employees;
    private double income;
    private Random random;

    public Company() {
        this.employees = new ArrayList<>();
        this.random = new Random();
        this.income = generateIncome();
    }

    private double generateIncome() {
        return random.nextDouble() * 100_000 + 150_000;
    }

    public void hire(Employee employee) {
        employees.add(employee);
        employee.calculateBonus(income);
    }

    public void hireAll(List<Employee> newEmployees) {
        for (Employee employee : newEmployees) {
            hire(employee);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getTotalSalary).reversed())
                .limit(count)
                .toList();
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getTotalSalary))
                .limit(count)
                .toList();
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
} 