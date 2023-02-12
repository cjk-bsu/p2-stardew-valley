import static org.junit.Assert.*;
import org.junit.Test;

public class MaxHeapTest {

    @Test
    public void isEmptyTest1() {
        MaxHeap maxHeap = new MaxHeap();
        assertTrue(maxHeap.isEmpty());
        System.out.println("isEmptyTest1 passed.");
    }

    @Test
    public void isEmptyTest2() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        Task task = new Task(8, TaskInterface.TaskType.FISHING, "Fishing", 5);
        maxHeap.insert(task);
        assertFalse(maxHeap.isEmpty());
        System.out.println("isEmptyTest2 passed.");
    }

    @Test
    public void insertTest() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        Task task1 = new Task(8, TaskInterface.TaskType.FISHING, "Fishing", 5);
        Task task2 = new Task(9, TaskInterface.TaskType.MINING, "Mining", 8);
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        assertEquals(maxHeap.max(), task2);
        System.out.println("insertTest passed.");
    }
}
