
/*write a program to check login validation user name=admin,password=1234*/
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctUser = "admin";
        int correctPass = 1234;
        int count = 0;
        while (count < 3) {
            System.out.print("Enter username: ");
            String user = sc.nextLine();
            System.out.print("Enter password: ");
            int pass = sc.nextInt();
            sc.nextLine(); // clear buffer
            if (user.equals(correctUser) && pass == correctPass) {
                System.out.println("Login Successful");
                break;
            } 
            else if (!user.equals(correctUser)) {
                System.out.println("Wrong Username");
                count++;
            } 
            else if (pass != correctPass) {
                System.out.println("Wrong Password");
                count++;
            }
        }
        if (count == 3) {
            System.out.println("Account Blocked");
        }
        sc.close();
    }
}
