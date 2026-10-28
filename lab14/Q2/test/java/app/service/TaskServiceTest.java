
package app.service;

import app.model.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void addingTaskIncreasesCount() {
        TaskService service = new TaskService();

        service.addTask("Learn Java");

        assertEquals(1, service.getTaskCount());
    }

    @Test
    void invalidActionThrowsException() {
        TaskService service = new TaskService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.performAction("delete")
        );
    }

    @Test
    void savedDataReloadsUnchanged() throws IOException {
        TaskService original = new TaskService();

        original.addTask("Learn Java");
        original.addTask("Practice JUnit");
        original.addTask("Build MiniBank");

        Path file = tempDir.resolve("tasks.txt");
        original.save(file);

        TaskService restored = new TaskService();
        restored.load(file);

        assertEquals(
            original.getAllTasks(),
            restored.getAllTasks()
        );

        assertEquals(3, restored.getTaskCount());
    }
}
