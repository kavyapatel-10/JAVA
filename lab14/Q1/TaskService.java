
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
}
