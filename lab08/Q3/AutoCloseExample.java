
class MyResource implements AutoCloseable {

    public MyResource() {
        System.out.println("Resource opened.");
    }

    public void doWork() {

        System.out.println("Resource is being used.");

        throw new RuntimeException(
            "Original error occurred!"
        );
    }

    // Automatically called when try block finishes
    @Override
    public void close() {

        System.out.println("Resource closed automatically.");
    }
}

// Main class
public class AutoCloseExample {

    public static void main(String[] args) {

        try (MyResource resource = new MyResource()) {

            resource.doWork();

        }

        catch (Exception e) {

            System.out.println("Caught Exception: " + e.getMessage());

        }

        finally {

            System.out.println("Finally block executed.");
        }
    }
}