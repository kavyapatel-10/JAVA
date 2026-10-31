import java.lang.annotation.*;
import java.lang.reflect.Method;

// Custom Run annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

// Test class
class MyTests {

    @Run
    public void testAddition() {
        System.out.println("Running Addition Test");
        System.out.println(10 + 20 == 30);
    }

    @Run
    public void testSubtraction() {
        System.out.println("Running Subtraction Test");
        System.out.println(20 - 10 == 10);
    }

    public void normalMethod() {
        System.out.println("This method will not run");
    }

    @Run
    public void testMultiplication() {
        System.out.println("Running Multiplication Test");
        System.out.println(5 * 5 == 25);
    }
}

// Mini Test Runner
public class MiniTestRunner {

    public static void main(String[] args) {

        MyTests testObject = new MyTests();

        Class<?> cls = testObject.getClass();

        Method[] methods = cls.getDeclaredMethods();

        int count = 0;

        for (Method method : methods) {

            // Check Run annotation
            if (method.isAnnotationPresent(Run.class)) {

                try {

                    method.invoke(testObject);

                    count++;

                } catch (Exception e) {
                    System.out.println("Test failed: " + method.getName());
                }
            }
        }

        System.out.println("--------------------");
        System.out.println("Total tests executed: " + count);
    }
}
