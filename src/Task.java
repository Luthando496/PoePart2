import javax.swing.JOptionPane;

public class Task {

    public static void main(String[] args) {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
        int totalHours = 0;

        for (int i = 1; i <= numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");

            while (!checkTaskDescription(taskDescription)) {
                taskDescription = JOptionPane.showInputDialog("Task description too long. Enter again (max 50 characters):");
            }

            String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (hours):"));
            totalHours += taskDuration;
            String taskID = createTaskID(i);

            String[] statusOptions = {"To Do", "Doing", "Done"};
            int statusIndex = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            String taskStatus = statusOptions[statusIndex];

            String taskDetails = printTaskDetails(taskName, i, taskDescription, developerDetails, taskDuration, taskID, taskStatus);
            JOptionPane.showMessageDialog(null, taskDetails);
        }

        JOptionPane.showMessageDialog(null, "Total combined hours for all tasks: " + returnTotalHours(totalHours));
    }

    static boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    static String createTaskID(int taskNumber) {
        return "TASK-" + taskNumber;
    }

    static String printTaskDetails(String taskName, int taskNumber, String taskDescription,
                                   String developerDetails, int taskDuration, String taskID, String taskStatus) {
        return "Task Name: " + taskName + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Duration: " + taskDuration + " hours\n" +
                "Task ID: " + taskID + "\n" +
                "Task Status: " + taskStatus;
    }

    static int returnTotalHours(int totalHours) {
        return totalHours;
    }
}
