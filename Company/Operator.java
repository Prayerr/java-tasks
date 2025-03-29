package Company;

public class Operator extends Employee {
    public Operator(String fullName, int age, double salary) {
        super(fullName, age, salary);
    }

    @Override
    public void calculateBonus(double companyIncome) {
        setBonus(getSalary() * 0.05);
    }
} 