/**
 *
 *
 * @author carsonkeller
 */
public class TaskGenerator implements TaskGeneratorInterface {
    private int currentEnergyStorage;

    public TaskGenerator() {

    }

    public TaskGenerator() {

    }

    @Override
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
        return new Task(hourCreated, taskType, taskDescription, 0);
    }

    @Override
    public void decrementEnergyStorage(Task.TaskType taskType) {

    }

    @Override
    public void resetCurrentEnergyStorage() {

    }

    @Override
    public int getCurrentEnergyStorage() {
        return this.currentEnergyStorage;
    }

    @Override
    public void setCurrentEnergyStorage(int newEnergyNum) {
        this.currentEnergyStorage = newEnergyNum;
    }

    @Override
    public boolean generateTask() {
        return false;
    }

    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        return 0;
    }

    @Override
    public String toString(Task task, Task.TaskType taskType) {
        if(taskType == Task.TaskType.MINING) {
            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FISHING) {
            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FORAGING) {
            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FEEDING) {
            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.SOCIALIZING) {
            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        else { return "nothing to see here..."; }
    }
}
