package payment;
import java.util.Scanner;

interface Payment {
    void makePayment(double amount);
}

class UPIPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("UPI Payment was successful.");
        System.out.println("Debited Amount: ₹" + amount);
    }
}

class CashPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Cash Payment was successful.");
        System.out.println("Debited Amount: ₹" + amount);
    }
}


class CreditCardPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Credit Card Payment was successful.");
        System.out.println("Debited Amount: ₹" + amount);
    }
}


class DebitCardPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Debit Card Payment was successful.");
        System.out.println("Debited Amount: ₹" + amount);
    }
}

public class Transactionpayment {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Payment payment = null;

        System.out.print("Enter Payment Amount: ₹");
        double amount = sc.nextDouble();

        System.out.println("\nChoose Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Debit Card");
        System.out.println("4. Cash");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                payment = new UPIPayment();
                break;
            case 2:
                payment = new CreditCardPayment();
                break;
            case 3:
                payment = new DebitCardPayment();
                break;
            case 4:
                payment = new CashPayment();
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        payment.makePayment(amount);
        sc.close();
    }
}
