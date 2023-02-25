/**
 * This class details the construction and use of Task objects to be used in the TaskGenerator
 * class as part of a console-based Stardew Valley game simulation. This class implements the
 * TaskInterface to further define functionality and values.
 *
 * @author carsonkeller
 */
public class Task implements TaskInterface, Comparable<Task> {
    private int hourCreated, waitingTime, priority;
    private TaskType taskType;
    private String taskDescription;

    /**
     * This method is the primary constructor for the Task class and requires the following
     * parameters as delineated below.
     *
     * @param hourCreated - int value representing the hour in the game that the task was created
     * @param taskType - enum value representing the task type as defined in TaskInterface
     * @param taskDescription - string representing the description of the task
     * @param priority - int value representing the priority level of the task
     */
    public Task(int hourCreated, TaskInterface.TaskType taskType, String taskDescription, int priority) {
        this.hourCreated = hourCreated;
        this.taskType = taskType;
        this.taskDescription = taskDescription;
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public TaskType getTaskType() {
        return this.taskType;
    }

    @Override
    public String getTaskDescription() {
        return this.taskDescription;
    }

    @Override
    public void incrementWaitingTime() {
        this.waitingTime++;
    }

    @Override
    public void resetWaitingTime() {
        this.waitingTime = 0;
    }

    @Override
    public int getWaitingTime() {
        return this.waitingTime;
    }

    @Override
    public int compareTo(Task task) {
        if (this.priority < task.getPriority()) {
            return -1;
        } else if (this.priority > task.getPriority()) {
            return 1;
        } else {
            return Integer.compare(task.hourCreated, this.hourCreated);
        }
    }
}
