
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    void addingTaskIncreasesCount() {
        TaskService service = new TaskService();

        assertEquals(0, service.getTaskCount());

        service.addTask("Learn Java");

        assertEquals(1, service.getTaskCount());
    }

    @Test
    void addingMultipleTasksIncreasesCount() {
        TaskService service = new TaskService();

        service.addTask("Learn OOP");
        service.addTask("Practice JUnit");

        assertEquals(2, service.getTaskCount());
    }

    @Test
    void invalidActionThrowsException() {
        TaskService service = new TaskService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.performAction("delete")
        );
    }
}
