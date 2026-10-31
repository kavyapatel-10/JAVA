import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Custom NotBlank annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

// Custom MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// SignupForm class
class SignupForm {

    @NotBlank
    @MaxLength(20)
    String username;

    @NotBlank
    @MaxLength(30)
    String password;

    @NotBlank
    @MaxLength(50)
    String email;

    SignupForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

// Validator class
class Validator {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Class<?> cls = obj.getClass();

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                // Check NotBlank annotation
                if (field.isAnnotationPresent(NotBlank.class)) {

                    if (value == null || value.toString().trim().isEmpty()) {
                        errors.add(field.getName() + " cannot be blank");
                    }
                }

                // Check MaxLength annotation
                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength annotation =
                            field.getAnnotation(MaxLength.class);

                    int max = annotation.value();

                    if (value != null && value.toString().length() > max) {
                        errors.add(field.getName()
                                + " must not exceed " + max + " characters");
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add("Cannot access field: " + field.getName());
            }
        }

        return errors;
    }
}

// Main class
public class FormValidator {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
                "",
                "thispasswordiswaytoolong123456",
                "test@gmail.com"
        );

        List<String> errors = Validator.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid!");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}