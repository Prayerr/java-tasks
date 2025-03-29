package Company;

public class Programmer extends Employee {
    public Programmer(String fullName, int age, double salary) {
        super(fullName, age, salary);
    }

    @Override
    public void calculateBonus(double companyIncome) {
        setBonus(companyIncome * 0.1);
    }
} 