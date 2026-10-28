
package app;

import app.service.TaskService;
import app.model.Task;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        Path file = Path.of("tasks.txt");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Task Manager ---");
                System.out.println("1. Add task");
                System.out.println("2. List tasks");
                System.out.println("3. Count tasks");
                System.out.println("4. Save tasks");
                System.out.println("5. Load tasks");
                System.out.println("0. Exit");
                System.out.print("Choice: ");

                String choice = sc.nextLine();

                try {
                    switch (choice) {
                        case "1":
                            System.out.print("Enter task: ");
                            service.addTask(sc.nextLine());
                            System.out.println("Task added.");
                            break;

                        case "2":
                            for (Task task : service.getAllTasks()) {
                                System.out.println(task);
                            }
                            break;

                        case "3":
                            System.out.println(
                                "Count: " + service.getTaskCount()
                            );
                            break;

                        case "4":
                            service.save(file);
                            System.out.println("Tasks saved.");
                            break;

                        case "5":
                            service.load(file);
                            System.out.println("Tasks loaded.");
                            break;

                        case "0":
                            return;

                        default:
                            System.out.println("Invalid choice.");
                    }
                } catch (IllegalArgumentException | IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
