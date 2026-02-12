import java.util.Scanner;
class Bank {
    protected double balance;
    Bank(double balance) {
        this.balance = balance;
    }
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
    void display() {
        System.out.println("Current Balance: " + balance);
    }
}
class Savings extends Bank {

    Savings(double balance) {
        super(balance);   
    }
}
public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();
        Savings obj = new Savings(bal);
        System.out.print("Enter deposit amount: ");
        double dep = sc.nextDouble();
        obj.deposit(dep);
        System.out.print("Enter withdrawal amount: ");
        double wd = sc.nextDouble();
        obj.withdraw(wd);
        obj.display();
        sc.close();
    }
}
