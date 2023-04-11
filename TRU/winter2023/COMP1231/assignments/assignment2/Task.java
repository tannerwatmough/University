/* ===========================================================================
 * Task.java
 * 
 * Tanner Watmough T00712721
 * COMP 1231 Assignment 2 Question 1
 * 
 * This is the Task class. It has various constructors, a priority,  a
 * description value and setter and getter methods for the priority and 
 * description values. 
 * 
 * It implements the Priority interface and the Comparable interface and defines
 * their required methods. 
 * 
 * There are two methods that will sort a Task[] array from highest to lowest
 * priority and from lowest to highest priority. 
 * 
 * Finally there is a toString() method which will return the task description
 * and priority. 
 * ===========================================================================
 */

// Implements used to use interfaces
public class Task implements Priority, Comparable<Task> {
  private int priority;
  private String description;

  // Constructor without a priority value. Automatically sets priority to MEDIUM
  // or 5. Takes in a string as the task description.
  public Task(String desc) {
    priority = MEDIUM;
    description = desc;
  }

  // Constructor that takes both description and priority as arguments.
  public Task(String desc, int priority) {
    description = desc;

    // If priority is less than the LOWEST (1), it is set to LOWEST instead.
    if (priority < LOWEST)
      this.priority = LOWEST;
    // If priority is greater than HIGHEST (10), it is set to HIGHEST instead.
    else if (priority > HIGHEST)
      this.priority = HIGHEST;
    // If priority in range, it is set to the passed value.
    else
      this.priority = priority;
  }

  // Sets description.
  public void setDescription(String desc) {
    description = desc;
  }

  // Getter for description
  public String getDescription() {
    return description;
  }

  // Sets priority of object. Ensures the set value is between the LOWEST and
  // HIGHEST value determined by the Priority interface.
  public void setPriority(int value) {
    if (value < LOWEST)
      priority = LOWEST;
    else if (value > HIGHEST)
      priority = HIGHEST;
    else
      priority = value;
  }

  // Returns priority of object.
  public int getPriority() {
    return priority;
  }

  // Compare to method. Calls the Integer compare method and passes in the
  // priority integer values of calling object's priority and the passed Task
  // object's priority. This returns a value less than 0, 0, or greater than 0
  // depending on if this object's priority is less than the passed object's
  // priority (less than 0), equal to pass object's priority (0), or greater
  // than the passed object's priority (greater than 0).
  public int compareTo(Task anotherTask) {
    return Integer.compare(this.priority, anotherTask.priority);
  }

  // Sorts a Task[] array from high to low.
  public static Task[] sortHigh(Task[] taskList) {
    // Compares each position in array to next position. Very inefficient.
    for (int i = 0; i < taskList.length; i++) {
      for (int j = i + 1; j < taskList.length; j++) {
        // Create a temp holding Task object
        Task temp;
        // If the lower index task is less than the task in a greater index,
        // switch the values position.
        if (taskList[i].getPriority() < taskList[j].getPriority()) {
          temp = taskList[i];
          taskList[i] = taskList[j];
          taskList[j] = temp;
        }
      }
    }

    // Return sorted taskList.
    return taskList;
  }

  // Sorts a Task[] array from low to high.
  public static Task[] sortLow(Task[] taskList) {
    // Compares each position in array to next position. Very inefficient.
    for (int i = 0; i < taskList.length; i++) {
      for (int j = i + 1; j < taskList.length; j++) {
        // Create a temp holding Task object
        Task temp;
        // If the first task is greater than the task in a greater index,
        // switch the values position.
        if (taskList[i].getPriority() > taskList[j].getPriority()) {
          temp = taskList[i];
          taskList[i] = taskList[j];
          taskList[j] = temp;
        }
      }
    }

    // Return sorted taskList.
    return taskList;
  }

  // When a Task object is printed to console, it displays its description and
  // priority values in a return string.
  public String toString() {
    String result = "Description: " + description + "\n";
    result += "Priority: " + priority;

    return result;
  }
}