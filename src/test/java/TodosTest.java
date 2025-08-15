import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {
    @Test
    public void shouldAddAndFindAllTasks() {
        Todos todos = new Todos();
        assertEquals(0, todos.findAll().length);

        Task task = new SimpleTask(1, "Задача");
        todos.add(task);
        Task[] result = todos.findAll();
        assertEquals(1, result.length);
        assertEquals(task, result[0]);
    }

    @Test
    public void shouldSearchTasks() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить Молоко"));
        todos.add(new Epic(2, new String[]{"Молоко", "Яйца"}));
        todos.add(new Meeting(3, "Обсуждение", "Молочные продукты", "Завтра"));

        Task[] milkResults = todos.search("Молоко");
        assertEquals(2, milkResults.length);

        Task[] dairyResults = todos.search("Молочные");
        assertEquals(1, dairyResults.length);
    }

    @Test
    public void shouldNotFindNonExistingTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Задача"));
        assertEquals(0, todos.search("Несуществующее").length);
    }

    private boolean containsTask(Task[] tasks, Task task) {
        for (Task t : tasks) {
            if (t.equals(task)) {
                return true;
            }
        }
        return false;
    }
}