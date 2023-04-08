


import java.util.*;

public class Priority implements Algorithm {
    private List<Task> queue;
    private Set<Task> completedTasks;
    private int currentTime;

    public Priority(List<Task> queue) {
        this.queue = queue;
        this.completedTasks = new HashSet<>();
        this.currentTime = 0;
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            Task currentTask = pickNextTask();
            int burstTime = currentTask.getBurst();
            System.out.println("Scheduled " + currentTask.getName() + " (priority " + currentTask.getPriority() + ", burst time " + burstTime + ")");
            
            // Execute the task
            for (int i = 0; i < burstTime; i++) {
                currentTime++;
                System.out.println("Time " + currentTime + ": " + currentTask.getName());
            }
            
            completedTasks.add(currentTask);
        }
    }

    public Task pickNextTask() {
        Task highestPriorityTask = null;
        for (Task task : queue) {
            if (!completedTasks.contains(task) && (highestPriorityTask == null || task.getPriority() < highestPriorityTask.getPriority())) {
                highestPriorityTask = task;
            }
        }
        return highestPriorityTask;
    }
}
