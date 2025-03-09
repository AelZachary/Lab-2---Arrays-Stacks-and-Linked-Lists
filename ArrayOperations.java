import java.util.LinkedList;
import java.util.Scanner;

public class DailyTaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part A: Task Array
        String[] tasks = {"Check email", "Attend lecture", "Exercise", "Read book", "Prepare meals"};
        boolean[] taskCompleted = new boolean[tasks.length]; // Array to track task completion status
        int taskCount = tasks.length;

        // Part B: Task Undo Stack
        TaskUndoStack taskUndoStack = new TaskUndoStack(10);

        // Part C: Dynamic Task List with Linked List
        LinkedList<String> dynamicTaskList = new LinkedList<>();
        dynamicTaskList.add("Listen to music");

        int choice;
        do {
            // Display the menu to the user
            System.out.println("\n===== Daily Task Manager =====");
            System.out.println("1. View tasks");
            System.out.println("2. Update a task");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. Undo task completion");
            System.out.println("5. Add a new task");
            System.out.println("6. Remove a task");
            System.out.println("7. Display all tasks");
            System.out.println("8. Generate ASCII art"); // New option to generate ASCII art
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // View tasks from the array
                    System.out.println("\nCurrent tasks (Array):");
                    displayTasks(tasks, taskCompleted);
                    break;
                case 2:
                    // Update a task in the array
                    System.out.println("\nEnter the index of the task you want to update (1-5):");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (index >= 1 && index <= taskCount) {
                        System.out.println("Enter the new task description:");
                        String newTask = scanner.nextLine();
                        tasks[index - 1] = newTask; // Subtract 1 to access the correct index in the array
                        System.out.println("Task updated successfully!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    // Mark a task as completed and push it onto the stack
                    System.out.println("\nEnter the index of the task to mark as completed (1-5):");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (taskIndex >= 1 && taskIndex <= taskCount) {
                        taskUndoStack.push(tasks[taskIndex - 1]); // Subtract 1 for correct index
                        taskCompleted[taskIndex - 1] = true; // Mark task as completed
                        System.out.println("Task marked as completed: " + tasks[taskIndex - 1]);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 4:
                    // Undo the last task completion
                    taskUndoStack.pop();
                    break;
                case 5:
                    // Add a new task to the dynamic linked list
                    System.out.println("\nEnter the new task description:");
                    String newDynamicTask = scanner.nextLine();
                    dynamicTaskList.add(newDynamicTask);
                    System.out.println("New task added to the dynamic list.");
                    break;
                case 6:
                    // Remove a task from the dynamic linked list
                    System.out.println("\nEnter the task description to remove:");
                    String taskToRemove = scanner.nextLine();
                    if (dynamicTaskList.remove(taskToRemove)) {
                        System.out.println("Task removed successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 7:
                    // Display all tasks from the dynamic linked list
                    System.out.println("\nDynamic task list:");
                    displayLinkedList(dynamicTaskList);
                    break;
                case 8:
                    // Generate and display ASCII art
                    displayASCIIArt();
                    break;
                case 9:
                    // Exit the application
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (choice != 9); // Loop until the user chooses to exit

        scanner.close();
    }

    // Method to display tasks in the array with index starting from 1
    public static void displayTasks(String[] tasks, boolean[] taskCompleted) {
        for (int i = 0; i < tasks.length; i++) {
            String taskDisplay = tasks[i];
            if (taskCompleted[i]) {
                taskDisplay += " (completed)"; // Add "(completed)" if the task is marked as completed
            }
            System.out.println((i + 1) + ". " + taskDisplay); // Add 1 to index for 1-based display
        }
    }

    // Method to display tasks in the linked list with index starting from 1
    public static void displayLinkedList(LinkedList<String> taskList) {
        int i = 1;
        for (String task : taskList) {
            System.out.println(i + ". " + task); // Display index starting from 1
            i++;
        }
    }

    // Method to display the ASCII art
    public static void displayASCIIArt() {
        System.out.println("....................................................................................................");
        System.out.println("....................................................................................................");
        System.out.println("....................................................................................................");
        System.out.println("....................................................................................................");
        System.out.println(".........................................................-+**********+=-:...........................");
        System.out.println("...................................................:=+*##################**+:.......................");
        System.out.println("................................................-+*###%%%%%%##################*+=:..................");
        System.out.println("...........................................-=+**####%%%%%%%%%####%%##############*=:................");
        System.out.println(".........................................-*#%%%%%%%%%%%%%%%%%%%%%%%%%%%##%%#######+:................");
        System.out.println(".......................................:=*#%%%%%%%%%%##########%%%%%%%%#%%%%%%%###+:................");
        System.out.println("........................................=#%%%%%%%%#**+++******##########%%%%%%%%##+:................");
        System.out.println(".......................................:*%%%%%#*+++====+++++***********####%%%%%%%+:................");
        System.out.println("......................................:*#%%#*+++++++====++++++++++++++***####%%%%%*:................");
        System.out.println(".....................................:-###**#####***+++++++++++++++++++++***####%%*:................");
        System.out.println("...............................-=+*########%##%%%##*****++++*********++++++***####+:................");
        System.out.println(".............................:#%*==++=+******#########****##############**********+:................");
        System.out.println("..............................#*+=++=+*++++++**#####%%%####################*******=:................");
        System.out.println(".............................:*#*++=+++**********#%%##%%#########*******+*#####**+=.................");
        System.out.println(".............................=*%*+=+*###########%#*+++####**********++++*******###+:................");
        System.out.println(".............................=+%#==++******+*++++====+*#%****#####*****++********#*:................");
        System.out.println("..............................=#***********++++======+*##**+++******#####******+++=:................");
        System.out.println(".............................:--=++****##*******+++++=+#%#*+++++++*++++**##**#**+=-.................");
        System.out.println("............................:==++++++++++*#########**+++**###**+++++++++++*******+-.................");
        System.out.println("...........................-=++++++++++**#%%%%##%%%%#**+****++**####*****##*+++**+-.................");
        System.out.println("..........................-=+++++++++***###%#####%%@@%#*******++++++++++=======+++=.................");
        System.out.println(".........................-=+++++++*****************######******++++++++++++=======-.................");
        System.out.println(".........................-+++******++++******+++++***####****++++++++++++++++=====-.................");
        System.out.println("........................:=++****++++*###########**+++++++++++++++++++++++++++++===-.................");
        System.out.println("........................-+++*+++++*#%%%%%%%%%%%%###*++++++++++*++**++++++++++++===-.................");
        System.out.println("........................-++++++**#%%#****###%%%%%%%#*++++++++++*++*********+++++==-.................");
        System.out.println(".......................:=+++++*###*********+++**#%%%##**+++++++++***********+++++=-.................");
        System.out.println(".......................:=++++*****##%%%%%######***#%%%##**++++++*************++++=-.................");
        System.out.println(".......................-=++*****###%%%%%%%%%%%%######%##******+**************++++=-.................");
        System.out.println(".......................-=++**#############%%%%%####***###********************++++=-.................");
        System.out.println(".......................-=+***#########################***********************+++==-.................");
        System.out.println(".......................-++***********###******##########********************++++==-.................");
        System.out.println(".......................-+++********########*******##########****************+++===-.................");
        System.out.println(".......................-=++*****#############*******##########*************++++===-.................");
        System.out.println(".......................:=+****################********##########***********+++===+=.................");
        System.out.println("........................=+**###################*******#############********+++++++=.................");
        System.out.println("........................:+*###%%%%%%%%%%%%%##########################******++++***=:................");
        System.out.println(".........................-*#%%%%%%%%%%%%%%%%%%########################*****++=+*##+:................");
    }
}

// Part B: Task Undo Stack Implementation (Stack class)
class TaskUndoStack {
    private String[] stack;
    private int top;
    private int capacity;

    public TaskUndoStack(int capacity) {
        this.capacity = capacity;
        stack = new String[capacity];
        top = -1;
    }

    // Push task onto the stack (mark as completed)
    public void push(String task) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow! Cannot add more tasks.");
        } else {
            stack[++top] = task;
            System.out.println("Task completed and added to stack: " + task);
        }
    }

    // Pop task from the stack (undo task completion)
    public void pop() {
        if (top == -1) {
            System.out.println("No tasks to undo.");
        } else {
            System.out.println("Undoing task: " + stack[top--]);
        }
    }

    // Display the stack contents
    public void displayStack() {
        if (top == -1) {
            System.out.println("No tasks in the stack.");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    // Peek the top task of the stack without removing it
    public String peek() {
        if (top == -1) {
            return null;
        }
        return stack[top];
    }
}
