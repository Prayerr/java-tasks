package Calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите операцию: +, -, *, /, log, ln, sin, cos или 'E' для выхода:");
            String operation = scanner.next().toLowerCase();
            
            if (operation.equals("e")) break;

            if (operation.matches("[+\\-*/]") || operation.matches("log|ln|sin|cos")) {
                System.out.print("Введите число: ");
                double num1 = scanner.nextDouble();
                double num2 = 0;

                if (operation.matches("[+\\-*/]") || operation.equals("log")) {
                    System.out.print("Введите второе число: ");
                    num2 = scanner.nextDouble();
                }
                
                System.out.println("Результат: " + calculate(operation, num1, num2));
            } else {
                System.out.println("Некорректная операция");
            }
        }
        scanner.close();
    }

    public static double calculate(String operation, double num1, double num2) {
        switch (operation) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num2 != 0 ? num1 / num2 : Double.NaN;
            case "log": return num2 > 0 ? Math.log(num1) / Math.log(num2) : Double.NaN;
            case "ln": return num1 > 0 ? Math.log(num1) : Double.NaN;
            case "sin": return Math.sin(Math.toRadians(num1));
            case "cos": return Math.cos(Math.toRadians(num1));
            default: return Double.NaN;
        }
    }
}
