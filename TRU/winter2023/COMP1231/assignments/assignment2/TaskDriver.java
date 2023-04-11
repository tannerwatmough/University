/* ===========================================================================
 * TaskDriver.java
 * 
 * Tanner Watmough T00712721
 * COMP 1231 Assignment 2 Question 1
 * 
 * This is a simple driver for the Task class. It creates an array of Task
 * objects with varying priorities by implementing the Priority interface. It
 * then compares the priorities of the objects to determine if the priority is
 * higher, lower, or equal to. Finally it sorts the Task[] array from high to 
 * low and than low to high. 
 * ===========================================================================
 */

public class TaskDriver {
  public static void main(String[] args) {
    // Create a new task list and populate with different Task objects.
    Task[] taskList = new Task[11];
    taskList[0] = new Task("Get a haircut", Priority.HIGHEST); // High Task
    taskList[1] = new Task("Do laundry", Priority.LOWEST); // Low Task
    taskList[2] = new Task("Shower", Priority.MEDIUM); // Medium Task
    taskList[3] = new Task("Shave beard", 10); // High Task (Numeric)
    taskList[4] = new Task("Clean kitchen", 1); // Low Task (Numeric)
    taskList[5] = new Task("Study", 5); // Medium Task (Numeric)
    taskList[6] = new Task("Finish assignment", 15); // High (Out of bounds)
    taskList[7] = new Task("Finish video game", -15); // Low (Out of bounds)
    taskList[8] = new Task("Get groceries"); // Medium (No set priority)
    taskList[9] = new Task("Eat sushi", 3); // Low-mid
    taskList[10] = new Task("Throw out old sushi", 7); // Mid-high

    // Print out unsorted array
    for (int i = 0; i < taskList.length; i++) {
      System.out.println(taskList[i].toString());
      System.out.println();
    }

    System.out.println("Higher priority comparisons");
    // Greater (higher priority) than comparisons
    priorityComparison(taskList, 0, 1);
    priorityComparison(taskList, 2, 1);
    priorityComparison(taskList, 10, 5);

    System.out.println();
    System.out.println("Equal priority comparisons");

    // Equal priority comparisons
    priorityComparison(taskList, 0, 3);
    priorityComparison(taskList, 0, 6);
    priorityComparison(taskList, 2, 8);

    System.out.println();
    System.out.println("Lower priority comparisons");

    // Less (lower priority) than comparisons
    priorityComparison(taskList, 4, 3);
    priorityComparison(taskList, 7, 8);
    priorityComparison(taskList, 10, 6);

    // I didn't understand the assignment instructions to implemment the
    // interface so the tasks are ranked by priority, so I instead created
    // two sort methods to show tasks by high priority to low, and low priorty
    // to high.

    // This sorts the TaskList[] from high to low.
    taskList = Task.sortHigh(taskList);

    // Provide space between console output from unsorted task list
    for (int i = 0; i < 3; i++)
      System.out.println();

    // Print out the high to low array.
    for (int i = 0; i < taskList.length; i++) {
      System.out.println(taskList[i].toString());
      System.out.println();
    }

    // Sort TaskList[] low to high
    taskList = Task.sortLow(taskList);

    // Provide space between console output from high to low array
    for (int i = 0; i < 3; i++)
      System.out.println();

    // Print out low to high array.
    for (int i = 0; i < taskList.length; i++) {
      System.out.println(taskList[i].toString());
      System.out.println();
    }
  }

  // Custom method to lower repeated code for comparisons. This is more of a
  // custom solution since it takes in a Task object array and positions you
  // want to compare between within the array. For non-arrayed objects, we
  // would use much of the same code but instead of taking in an array and two
  // indexes, we would take in two Task objects and call compareTo on them
  // directly.
  private static void priorityComparison(Task[] taskList, int pos1, int pos2) {
    // If compareTo returns 0, the objects are equal priority.
    if (taskList[pos1].compareTo(taskList[pos2]) == 0) {
      System.out.println(taskList[pos1].getDescription() + " (" +
          taskList[pos1].getPriority() + ") is equal priority to " +
          taskList[pos2].getDescription() + " (" +
          taskList[pos2].getPriority() + ")");
      // If compareTo returns a value less than 0, then the first position is
      // lower priority than the second position Task object.
    } else if (taskList[pos1].compareTo(taskList[pos2]) < 0) {
      System.out.println(taskList[pos1].getDescription() + " (" +
          taskList[pos1].getPriority() + ") is a lower priority than " +
          taskList[pos2].getDescription() + " (" +
          taskList[pos2].getPriority() + ")");
      // If it's not equal or lower priority, it must be higher priority.
    } else {
      System.out.println(taskList[pos1].getDescription() + " (" +
          taskList[pos1].getPriority() + ") is a higher priority than " +
          taskList[pos2].getDescription() + " (" +
          taskList[pos2].getPriority() + ")");
    }
  }
}