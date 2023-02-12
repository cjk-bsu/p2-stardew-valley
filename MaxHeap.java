/**
 * This class dictates the creation, access, and management of a heap-based data
 * structure to be utilized by a priority queue to store tasks by their relative
 * priority in a console-based Stardew Valley game simulation. This data structure
 * has an underlying base-1 index.
 *
 * @author carsonkeller
 */
public class MaxHeap {
    private Task[] heap;
    private int heapSize;
    private final int DEFAULT_HEAP_ARRAY_SIZE = 10;

    /**
     * Primary constructor of the MaxHeap class, creating a new heap of tasks of
     * size zero given a default heap array size value for the containing array.
     * It takes no parameters.
     */
    public MaxHeap() {
        heap = new Task[DEFAULT_HEAP_ARRAY_SIZE];
        heapSize = 0;
    }

    /**
     * This is secondary, overloaded constructor for the MaxHeap class that takes a
     * starter array of tasks as a parameter and transforms it into a max heap object
     * utilizing the buildMaxHeap method.
     *
     * @param starterArray - an initial, provided array of task objects to be trans-
     *                     formed into a max heap
     */
    public MaxHeap(Task[] starterArray) {
        this.heapSize = starterArray.length;
        heap = starterArray;
        buildMaxHeap();
    }

    /**
     * This method takes the index of a given task object in the heap structure,
     * calculates, and returns the index of that object's parent.
     *
     * @param index - int value of the child task's index in the heap
     * @return - int value of the parent task's index in the heap
     */
    private static int getParent(int index) {
        return index / 2;
    }

    /**
     * This method takes the index of a given parent task object in the heap structure,
     * calculates, and returns the index of the left child task.
     *
     * @param index - int value of the parent task's index in the heap
     * @return - int value of the left child task's index in the heap
     */
    private static int getLeft(int index) {
        return 2 * index;
    }

    /**
     * This method takes the index of a given parent task object in the heap structure,
     * calculates, and returns the index of the right child task.
     *
     * @param index - int value of the parent task's index in the heap
     * @return - int value of the right child task's index in the heap
     */
    private static int getRight(int index) {
        return (2 * index) + 1;
    }

    /**
     * This method takes the index of a primary task and the index of a target in order
     * to swap the values at those indices in the heap.
     *
     * @param index - int value of the primary task's index in the heap
     * @param target - int value of the target task's index in the heap
     */
    private void swapTasks(int index, int target) {
        Task tempVal = heap[index];
        heap[index] = heap[target];
        heap[target] = tempVal;
    }

    /**
     * This method creates a new array double the size of the current heap and copies
     * the existing task objects in the heap to the new array before assigning the new,
     * larger array as the locally stored heap.
     */
    private void increaseArrayLength() {
        Task[] tempArray = new Task[heapSize * 2];

        for (int i = 1; i < heap.length; i++) {
            tempArray[i] = heap[i];
        }

        heap = tempArray;
    }

    /**
     * This method takes the index of a task object in the heap, compares it to its
     * children objects before selecting the task with the highest priority and moving
     * it to that primary position in the heap. The method is recursively called to
     * continue moving the task object with the highest priority to the top of the heap.
     *
     * @param index - int value of the index of the target parent task object in the heap
     */
    private void heapify(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int largest = index;

        if (left <= heapSize && heap[left].compareTo(heap[largest]) == 1) {
            largest = left;
        }

        if (right <= heapSize && heap[right].compareTo(heap[largest]) == 1) {
            largest = right;
        }

        if (largest != index) {
            swapTasks(index, largest);

            heapify(largest);
        }
    }

    /**
     * This method returns the task object with the "max" or highest priority value in
     * the heap.
     *
     * @return - "max" task object with the highest priority value in the heap
     */
    public Task max() {
        return heap[1];
    }

    /**
     * This method extracts the task object with the "max" or highest priority value from
     * the heap and returns it.
     *
     * @return - "max" task object with the highest priority value after being extracted
     *          from the heap
     */
    public Task extractMax() {
        Task max = max();
        heap[1] = heap[heapSize];
        heapSize--;
        heapify(1);
        return max;
    }

    /**
     * This method utilizes the increaseKey method to insert tasks into the heap and put
     * it in the correct position based on the value of its priority and throws a heap
     * exception if any issues arise.
     *
     * @param task - new task object to be inserted into the heap
     * @throws HeapException - custom exception to be thrown when an issue with the heap
     *                        arises
     */
    public void insert(Task task) throws HeapException {
        if (heapSize == (heap.length - 1)) {
            increaseArrayLength();
        }

        heapSize++;
        increaseKey(task, task.getPriority());
    }

    /**
     * This method takes a task and a priority value, searches for the task in the heap,
     * and, if found, updates the priority and ensures it is in the correct heap structure
     * organized by the relative priority level or throws a heap exception if any issues
     * arise.
     *
     * @param task - Task object that is searched for in the heap to then increase the
     *              priority level of
     * @param newPriority - int value of the task's intended priority level
     * @throws HeapException - custom exception to be thrown when an issue with the heap
     *                        arises
     */
    public void increaseKey(Task task, int newPriority) throws HeapException {
        if (newPriority < task.getPriority()) {
            throw new HeapException("New priority is less than current priority.");
        }

        task.setPriority(newPriority);

        int index = -1;

        for (int i = 1; i < heapSize; i++) {
            if (heap[i].equals(task)) {
                index = i;
            }
        }

        while (index > 1 && heap[getParent(index)].getPriority() < heap[index].getPriority()) {
            swapTasks(index, getParent(index));

            index = getParent(index);
        }
    }

    /**
     * This method returns a boolean true if the heap size is 0 or false for any other heap
     * size as this indicates the heap is not empty.
     *
     * @return - boolean value indicating the emptiness of the heap
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * This method utilizes a for loop to repeatedly call the heapify method to arrange a
     * provided array into a max heap data structure.
     */
    private void buildMaxHeap() {
        for (int i = heapSize / 2; i > 0; i--) {
            heapify(i);
        }
    }
}
