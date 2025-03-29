package taskmanager;

import java.time.LocalDate;
import java.util.*;

public class TaskManager {
    private List<Task> tasks;
    private LinkedList<Task> viewHistory;
    private static final int MAX_HISTORY_SIZE = 5;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.viewHistory = new LinkedList<>();
    }

    public void addTask(String title, String description, LocalDate date) {
        Task task = new Task(title, description, date);
        tasks.add(task);
    }

    public List<Task> getTasksForDate(LocalDate date) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDate().equals(date)) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> getTasksForWeek(LocalDate startDate) {
        List<Task> result = new ArrayList<>();
        LocalDate endDate = startDate.plusDays(6);
        for (Task task : tasks) {
            if (!task.getDate().isBefore(startDate) && !task.getDate().isAfter(endDate)) {
                result.add(task);
            }
        }
        return result;
    }

    public void addToHistory(Task task) {
        viewHistory.remove(task);
        viewHistory.addFirst(task);
        if (viewHistory.size() > MAX_HISTORY_SIZE) {
            viewHistory.removeLast();
        }
    }

    public List<Task> getViewHistory() {
        return new ArrayList<>(viewHistory);
    }
} 