import java.util.HashMap;
import java.util.Scanner;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, String> contacts = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n----- CONTACT MANAGEMENT SYSTEM -----");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        if (contacts.size() == 10) {
                            System.out.println("ERROR: Only 10 contacts allowed");
                            break;
                        }
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        if (contacts.containsKey(name)) {
                            System.out.println("ERROR: Name already exists!");
                            break;
                        }
                        System.out.print("Enter Phone Number: ");
                        String phone = sc.nextLine();
                        if (!phone.matches("\\d{10}")) {
                            System.out.println("ERROR: Phone number must be exactly 10 digits");
                            break;
                        }
                        if (contacts.containsValue(phone)) {
                            System.out.println("ERROR: Phone number already exists!");
                            break;
                        }
                        contacts.put(name, phone);
                        System.out.println("Contact added successfully");
                        break;
                    case 2:
                        System.out.print("Enter Name to Search: ");
                        String searchName = sc.nextLine();

                        if (contacts.containsKey(searchName)) {
                            System.out.println("Phone Number: " + contacts.get(searchName));
                        } else {
                            System.out.println("Contact not found");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Name to Edit: ");
                        String editName = sc.nextLine();

                        if (!contacts.containsKey(editName)) {
                            System.out.println("Contact not found");
                            break;
                        }

                        System.out.print("Enter New Phone Number: ");
                        String newPhone = sc.nextLine();

                        if (!newPhone.matches("\\d{10}")) {
                            System.out.println("ERROR: Phone number must be exactly 10 digits");
                            break;
                        }

                        if (contacts.containsValue(newPhone)) {
                            System.out.println("ERROR: Phone number already exists!");
                            break;
                        }

                        contacts.put(editName, newPhone);
                        System.out.println("Contact updated successfully");
                        break;
                    case 4:
                        System.out.print("Enter Name to Delete: ");
                        String deleteName = sc.nextLine();

                        if (contacts.remove(deleteName) != null) {
                            System.out.println("Contact deleted successfully");
                        } else {
                            System.out.println("Contact not found");
                        }
                        break;
                    case 5:
                        if (contacts.isEmpty()) {
                            System.out.println("No contacts available");
                        } else {
                            System.out.println("\nSaved Contacts:");
                            for (String key : contacts.keySet()) {
                                System.out.println("Name: " + key + " | Phone: " + contacts.get(key));
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Program exited successfully");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("ERROR: Please enter valid input");
                sc.nextLine(); 
            }
        }
    }
}
