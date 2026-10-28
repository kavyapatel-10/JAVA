import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Student[] students = {
            new Student(101, "Aarav", "TOKEN-A"),
            new Student(102, "Mira", "TOKEN-B")
        };

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("students.dat"))) {

            out.writeObject(students);

            System.out.println(
                "Saved " + students.length + " Student objects."
            );

        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("students.dat"))) {

            Student[] loaded = (Student[]) in.readObject();

            System.out.println("Loaded objects:");

            for (Student s : loaded) {
                System.out.println(s);
            }

            System.out.println(
                "Transient field check: sessionToken was not restored."
            );

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }
}
