import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class delineates a test suite designed to test the accuracy and functionality
 * of the MaxHeap class and data structure to ensure that it is functioning fully as
 * expected.
 *
 * @author carsonkeller
 */
public class MaxHeapTest {
    private Task task1 = new Task(8, TaskInterface.TaskType.FISHING, "Fishing", 5);
    private Task task2 = new Task(9, TaskInterface.TaskType.MINING, "Mining", 8);
    private Task task3 = new Task(3, TaskInterface.TaskType.SOCIALIZING, "Socializing", 3);
    private Task task4 = new Task(6, TaskInterface.TaskType.FORAGING, "Foraging", 5);

    /**
     * This test ensures a new, empty MaxHeap is empty.
     */
    @Test
    public void isEmptyTest1() {
        MaxHeap maxHeap = new MaxHeap();
        assertTrue(maxHeap.isEmpty());
        System.out.println("isEmptyTest1 passed.");
    }

    /**
     * This test ensures a new MaxHeap with one element is not marked as empty.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void isEmptyTest2() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        assertFalse(maxHeap.isEmpty());
        System.out.println("isEmptyTest2 passed.");

    }

    /**
     * This test ensures that a maxHeap with one element is actually marked empty after that
     * single element is removed.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void isEmptyTest3() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        assertTrue(maxHeap.isEmpty());
        System.out.println("isEmptyTest3 passed.");
    }

    /**
     * This test inserts two tasks of different priority levels and ensures that the
     * proper ordering is maintained.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void insertTest1() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        assertEquals(task2, maxHeap.max());
        assertEquals(task2, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        System.out.println("insertTest1 passed.");
    }

    /**
     * This test inserts two tasks of equal priority level and ensures that the proper
     * ordering is maintained.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void insertTest2() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task4);
        assertEquals(task4, maxHeap.max());
        assertEquals(task4, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        System.out.println("insertTest2 passed.");
    }

    /**
     * This test inserts three tasks of different priority levels and ensures that the
     * proper ordering is maintained.
     *
     * @throws HeapException throws custom HeapException if insert fails
     */
    @Test
    public void insertTest3() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        maxHeap.insert(task3);
        assertEquals(task2, maxHeap.max());
        assertEquals(task2, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        assertEquals(task3, maxHeap.max());
        assertEquals(task3, maxHeap.extractMax());
        System.out.println("insertTest3 passed.");
    }

    /**
     * Test test inserts three tasks with two having the same priority and ensures that the
     * proper ordering is maintained.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void insertTest4() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task3);
        maxHeap.insert(task1);
        maxHeap.insert(task4);
        assertEquals(task4, maxHeap.max());
        assertEquals(task4, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        assertEquals(task3, maxHeap.max());
        assertEquals(task3, maxHeap.extractMax());
        System.out.println("insertTest4 passed.");
    }

    /**
     * This test inserts two tasks of unequal priorities to ensure that the correct tasks
     * are retrieved in the order of decreasing priority.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void extractMaxTest1() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        assertEquals(task2, maxHeap.max());
        assertEquals(task2, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        System.out.println("extractMaxTest1 passed.");
    }

    /**
     * This test inserts three tasks of unequal priorities to ensure that the correct tasks
     * are retrieved in the order of decreasing priority.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void extractMaxTest2() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        maxHeap.insert(task3);
        assertEquals(task2, maxHeap.max());
        assertEquals(task2, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        assertEquals(task3, maxHeap.max());
        assertEquals(task3, maxHeap.extractMax());
        System.out.println("extractMaxTest2 passed.");
    }

    /**
     * This test inserts two tasks of equal priorities to ensure that the correct tasks are
     * retrieved in the order of earliest hour created first.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void extractMaxTest3() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task4);
        assertEquals(task4, maxHeap.max());
        assertEquals(task4, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        System.out.println("extractMaxTest3 passed.");
    }

    /**
     * This test inserts three tasks with two of equal priorities to ensure that the correct
     * tasks are retrieved in the order of decreasing priority or by earliest hour created
     * if their priorities are equal.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void extractMaxTest4() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task3);
        maxHeap.insert(task1);
        maxHeap.insert(task4);
        assertEquals(task4, maxHeap.max());
        assertEquals(task4, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        assertEquals(task3, maxHeap.max());
        assertEquals(task3, maxHeap.extractMax());
        System.out.println("extractMaxTest4 passed.");
    }

    /**
     * This test ensures that a MaxHeap with two tasks retains the proper ordering when the
     * priority key value is increased on a lower leaf.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void increaseKeyTest1() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        assertEquals(task2, maxHeap.max());
        maxHeap.increaseKey(task1, 9);
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        assertEquals(task2, maxHeap.max());
        assertEquals(task2, maxHeap.extractMax());
        System.out.println("increaseKeyTest1 passed.");
    }

    /**
     * This test ensures that a MaxHeap with three tasks retains the proper ordering when the
     * priority key value is increased on a lower leaf.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void increaseKeyTest2() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        maxHeap.insert(task3);
        maxHeap.increaseKey(task3, 9);
        assertEquals(task3, maxHeap.max());
        assertEquals(task3, maxHeap.extractMax());
        assertEquals(task2, maxHeap.max());
        assertEquals(task2, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        System.out.println("increaseKeyTest2 passed.");
    }

    /**
     * This test ensures that a MaxHeap with three tasks retains the proper ordering when the
     * priority key value of a lower leaf is increased to equal that of another leaf.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void increaseKeyTest3() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        maxHeap.insert(task3);
        assertEquals(task2, maxHeap.max());
        maxHeap.increaseKey(task3, 8);
        assertEquals(task3, maxHeap.max());
        assertEquals(task3, maxHeap.extractMax());
        assertEquals(task2, maxHeap.max());
        assertEquals(task2, maxHeap.extractMax());
        assertEquals(task1, maxHeap.max());
        assertEquals(task1, maxHeap.extractMax());
        System.out.println("increaseKeyTest3 passed.");
    }

    /**
     * This method takes a MaxHeap and ensures that it satisfies the max-heap property.
     *
     * @param maxHeap - MaxHeap value representing a max heap of Task objects
     * @return - boolean value of success (true) or failure (false)
     */
    public boolean checkIfMaxHeapTest(MaxHeap maxHeap) {
        Task[] heap = maxHeap.heap;

        for (int i = 1; i <= maxHeap.heapSize; i++) {
            int leftLeaf = i * 2;
            int rightLeaf = (i * 2) + 1;

            if (leftLeaf <= maxHeap.heapSize && rightLeaf <= maxHeap.heapSize) {
                if (heap[i].compareTo(heap[leftLeaf]) != 1 || heap[i].compareTo(heap[rightLeaf]) != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * This method takes an array of tasks and ensures that the tasks are sorted
     * according to priority.
     *
     * @param tasks - an array of Task objects
     * @return - boolean value of success (true) or failure (false)
     */
    public boolean checkIfSortedTest(Task[] tasks) {
        for (int i = 0; i < tasks.length - 1; i++) {
                if (tasks[i].compareTo(tasks[i + 1]) != 1) {
                    return false;
            }
        }

        return true;
    }

    /**
     * This test ensures that a MaxHeap of three tasks inserted in the order of increasing
     * priorities are properly sorted both in the heap and after being extracted to an
     * external tasks array.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void insertAscendingTest() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task3);
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        assertTrue(checkIfMaxHeapTest(maxHeap));
        Task[] tasks = new Task[3];
        tasks[0] = maxHeap.extractMax();
        tasks[1] = maxHeap.extractMax();
        tasks[2] = maxHeap.extractMax();
        assertTrue(checkIfSortedTest(tasks));
        System.out.println("insertAscendingTest passed.");
    }

    /**
     * This test ensures that a MaxHeap of three tasks inserted in the order of decreasing
     * priorities are properly sorted both in the heap and after being extracted to an
     * external tasks array.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void insertDescendingTest() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task2);
        maxHeap.insert(task1);
        maxHeap.insert(task3);
        assertTrue(checkIfMaxHeapTest(maxHeap));
        Task[] tasks = new Task[3];
        tasks[0] = maxHeap.extractMax();
        tasks[1] = maxHeap.extractMax();
        tasks[2] = maxHeap.extractMax();
        assertTrue(checkIfSortedTest(tasks));
        System.out.println("insertDescendingTest passed.");
    }

    /**
     * This test ensures that a MaxHeap of three tasks inserted in a random order in terms
     * of their priorities are properly sorted both in the heap and after being extracted
     * to an external tasks array.
     *
     * @throws HeapException - throws custom HeapException if insert fails
     */
    @Test
    public void insertRandomTest() throws HeapException {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(task1);
        maxHeap.insert(task3);
        maxHeap.insert(task2);
        assertTrue(checkIfMaxHeapTest(maxHeap));
        Task[] tasks = new Task[3];
        tasks[0] = maxHeap.extractMax();
        tasks[1] = maxHeap.extractMax();
        tasks[2] = maxHeap.extractMax();
        assertTrue(checkIfSortedTest(tasks));
        System.out.println("insertRandomTest passed.");
    }
}
