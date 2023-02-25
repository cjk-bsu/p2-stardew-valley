/**
 *
 *
 * @author carsonkeller
 */
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {

    public MyPriorityQueue() {
        super();
    }

    @Override
    public void enqueue(Object task) {
        try {
            super.insert((Task)task);
        } catch (HeapException e) {
            System.out.println("HeapException thrown. " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public Task dequeue() {
        return super.extractMax();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void update(int timeToIncrementPriority, int maxPriority) {
        for (int i = 0; i < super.heapSize; i++) {
            Task currentTask = super.heap[i];
            currentTask.incrementWaitingTime();

            if (currentTask.getWaitingTime() >= timeToIncrementPriority) {
                currentTask.resetWaitingTime();
                if (currentTask.getPriority() < maxPriority) {
                    currentTask.setPriority(currentTask.getPriority() + 1);
                    try {
                        super.increaseKey(currentTask, currentTask.getPriority());
                    } catch (HeapException e) {
                        System.out.println("HeapException thrown. " + e.toString());
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
