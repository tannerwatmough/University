/* ===========================================================================
 * Priority.java
 * 
 * Tanner Watmough T00712721
 * COMP 1231 Assignment 2 Question 1
 * 
 * This is a simple interface that defines priority constants of LOw, MEDIUM,
 * and HIGH. It then makes sure all classes that implement this interface must
 * have a setPriority and getPriority method. 
 * ===========================================================================
 */
public interface Priority {
  // Constants as determined by assignment instructions
  final int LOWEST = 1;
  final int MEDIUM = 5;
  final int HIGHEST = 10;

  // Ensures a value is passed to set an object's priority
  void setPriority(int value);

  // Ensures an int value is returned as a priority value
  int getPriority();
}