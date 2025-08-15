import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {
    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Купить молоко");
        assertTrue(task.matches("молоко"));
        assertFalse(task.matches("хлеб"));
    }

    @Test
    public void shouldMatchEpic() {
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        assertTrue(epic.matches("Молоко"));
        assertTrue(epic.matches("яйца"));
        assertFalse(epic.matches("сыр"));
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(3, "Обсуждение", "Молочные продукты", "Завтра");
        assertTrue(meeting.matches("Молочные"));
        assertFalse(meeting.matches("вчера"));
    }
}