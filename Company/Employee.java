package Company;

public abstract class Employee {
    private String fullName;
    private int age;
    private double salary;
    private double bonus;

    public Employee(String fullName, int age, double salary) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
        this.bonus = 0;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTotalSalary() {
        return salary + bonus;
    }

    public abstract void calculateBonus(double companyIncome);
} 