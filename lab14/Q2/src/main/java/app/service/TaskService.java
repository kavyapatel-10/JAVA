
package app.service;

import app.model.Task;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String name) {
        tasks.add(new Task(name));
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public void performAction(String action) {
        if (action == null) {
            throw new IllegalArgumentException(
                "Action cannot be null"
            );
        }

        switch (action.toLowerCase()) {
            case "add":
                addTask("Sample Task");
                break;
            case "list":
                getAllTasks().forEach(System.out::println);
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid action: " + action
                );
        }
    }

    public void save(Path file) throws IOException {
        List<String> lines = new ArrayList<>();

        for (Task task : tasks) {
            lines.add(task.getName());
        }

        Files.write(file, lines, StandardCharsets.UTF_8);
    }

    public void load(Path file) throws IOException {
        List<String> lines =
            Files.readAllLines(file, StandardCharsets.UTF_8);

        ArrayList<Task> loadedTasks = new ArrayList<>();

        for (String line : lines) {
            loadedTasks.add(new Task(line));
        }

        // Replace existing data only after successful parsing.
        tasks.clear();
        tasks.addAll(loadedTasks);
    }
}
