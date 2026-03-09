import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.regex.Pattern;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Validate {
    String type();
}

class Employee {

    @Validate(type="name")
    String name;

    @Validate(type="email")
    String email;

    @Validate(type="phone")
    String phone;

    Employee(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}


public class EmployeeValidation {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Employee emp = new Employee(name, email, phone);

        Field[] fields = emp.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Validate.class)) {

                Validate v = field.getAnnotation(Validate.class);
                field.setAccessible(true);
                String value = (String) field.get(emp);

                if (v.type().equals("name")) {
                    if (Pattern.matches("[A-Za-z ]+", value))
                        System.out.println("Valid Name");
                    else
                        System.out.println("Invalid Name");
                }

                if (v.type().equals("email")) {
                    if (Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", value))
                        System.out.println("Valid Email");
                    else
                        System.out.println("Invalid Email");
                }

                if (v.type().equals("phone")) {
                    if (Pattern.matches("\\d{10}", value))
                        System.out.println("Valid Phone Number");
                    else
                        System.out.println("Invalid Phone Number");
                }
            }
        }
    }
}
