/* ===========================================================================
 * Lockable.java
 * 
 * Tanner Watmough T00712721
 * COMP 1231 Assignment 2 Question 2
 * 
 * This is a simple interface that requires classes that implement it to define
 * a setKey, lock, unlock, and locked method. 
 * ===========================================================================
 */
public interface Lockable {
  // Establishes or sets the key
  void setKey(int key);

  // Locks the object
  void lock(int key);

  // Unlocks the object.
  void unlock(int key);

  // Returns if object is locked (True) or not (False)
  boolean locked();
}