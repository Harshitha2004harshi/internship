import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Scanner;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface EmailValidation {
    String message() default "Invalid Email Address";
}
class User {
    @EmailValidation
    String email;

    User(String email) {
        this.email = email;
    }
}
class EmailValidator {
    public static void validate(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(EmailValidation.class)) {
                field.setAccessible(true);
                try {
                    String value = (String) field.get(obj);

                    if (value.contains("@") && value.contains(".")) {
                        System.out.println("Valid Email Address");
                    } else {
                        System.out.println("Invalid Email Address");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class email {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        User user = new User(email);

        EmailValidator.validate(user);
    }
}
