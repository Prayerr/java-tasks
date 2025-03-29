package Company;

public class TopManager extends Employee {
    public TopManager(String fullName, int age, double salary) {
        super(fullName, age, salary);
    }

    @Override
    public void calculateBonus(double companyIncome) {
        if (companyIncome > 10_000_000) {
            setBonus(getSalary() * 1.5);
        }
    }
} 