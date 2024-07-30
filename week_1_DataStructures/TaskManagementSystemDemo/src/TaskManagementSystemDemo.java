public class TaskManagementSystemDemo {

    public static void main(String[] args) {
        TaskManagementSystem taskSystem = new TaskManagementSystem();

        // Add tasks
        taskSystem.addTask(new Task("T001", "Task 1", "Incomplete"));
        taskSystem.addTask(new Task("T002", "Task 2", "Complete"));
        taskSystem.addTask(new Task("T003", "Task 3", "Incomplete"));

        // Traverse tasks
        System.out.println("Tasks in the system:");
        taskSystem.traverseTasks();

        // Search for a task
        System.out.println("\nSearching for Task T002:");
        Task task = taskSystem.searchTask("T002");
        System.out.println(task != null ? task : "Task not found");

        // Delete a task
        System.out.println("\nDeleting Task T002:");
        taskSystem.deleteTask("T002");
        taskSystem.traverseTasks();
    }
}

// Task class
class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Task{" +
               "taskId='" + taskId + '\'' +
               ", taskName='" + taskName + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}

// TaskManagementSystem class
class TaskManagementSystem {
    private Node head;

    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Add a task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (head == null) return;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}
