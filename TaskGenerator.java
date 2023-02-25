import java.util.Random;

/**
 * This class details the construction and use of TaskGenerators to be created
 * and used in the public MyLifeInStardew class as part of the game simulation.
 * This class acts as a bridge between the Task class and the MyLifeInStardew
 * class to determine whether actions happen based on probability and create
 * tasks when needed.
 *
 * @author carsonkeller
 */
public class TaskGenerator implements TaskGeneratorInterface {
    private int currentEnergyStorage;
    private double probability;
    private Random random;

    /**
     * This is the primary constructor for the class that creates TaskGenerator
     * objects given a provided probability value.
     *
     * @param probability - double value representing the probability assigned to
     *                    this TaskGenerator
     */
    public TaskGenerator(double probability) {
        currentEnergyStorage = TaskGeneratorInterface.DEFAULT_ENERGY;
        this.probability = probability;
        random = new Random();
    }

    /**
     * This is the overloaded, secondary constructor for the class that creates
     * TaskGenerator but requires a seed for the random generator in addition to
     * the probability value.
     *
     * @param probability - double value representing the probability assigned to
     *                    this TaskGenerator
     * @param seed - long value representing the seed to initialize the Random
     *             object
     */
    public TaskGenerator(double probability, long seed) {
        currentEnergyStorage = TaskGeneratorInterface.DEFAULT_ENERGY;
        this.probability = probability;
        random = new Random(seed);
    }

    @Override
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
        return new Task(hourCreated, taskType, taskDescription, 0);
    }

    @Override
    public void decrementEnergyStorage(Task.TaskType taskType) {
        currentEnergyStorage = currentEnergyStorage - taskType.getEnergyPerHour();
    }

    @Override
    public void resetCurrentEnergyStorage() {
        currentEnergyStorage = TaskGeneratorInterface.DEFAULT_ENERGY;
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
        double randProbability = random.nextDouble();

        if (randProbability <= this.probability) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        if (unluckyProbability <= task.getTaskType().getPassingOutProbability()) {
            if (unluckyProbability <= task.getTaskType().getDyingProbability() && task.getTaskType() == TaskInterface.TaskType.MINING) {
                currentEnergyStorage = currentEnergyStorage / 4;
                task.setPriority(0);
                return 2;
            } else {
                currentEnergyStorage = currentEnergyStorage / 2;
                return 1;
            }
        } else {
            return 0;
        }
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
