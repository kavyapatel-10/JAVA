
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Task Manager ---");
                System.out.println("1. Add task");
                System.out.println("2. List tasks");
                System.out.println("3. Count tasks");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Task name: ");
                        String name = sc.nextLine();

                        try {
                            service.addTask(name);
                            System.out.println("Task added!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case "2":
                        if (service.getTaskCount() == 0) {
                            System.out.println("No tasks found.");
                        } else {
                            service.getAllTasks()
                                   .forEach(System.out::println);
                        }
                        break;

                    case "3":
                        System.out.println(
                            "Total tasks: " + service.getTaskCount()
                        );
                        break;

                    case "0":
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid menu choice.");
                }
            }
        }
    }
}
