import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        double num1 = sc.nextDouble();

        System.out.println("Enter second number:");
        double num2 = sc.nextDouble();

        System.out.println("Choose operation (+, -, *, /):");
        char operator = sc.next().charAt(0);

        double result;

        if (operator == '+') {
            result = num1 + num2;
            System.out.println("Result: " + result);
        } 
        else if (operator == '-') {
            result = num1 - num2;
            System.out.println("Result: " + result);
        } 
        else if (operator == '*') {
            result = num1 * num2;
            System.out.println("Result: " + result);
        } 
        else if (operator == '/') {
            if (num2 != 0) {
                result = num1 / num2;
                System.out.println("Result: " + result);
            } else {
                System.out.println("Cannot divide by zero!");
            }
        } 
        else {
            System.out.println("Invalid operator!");
        }

        sc.close();
    }
}
