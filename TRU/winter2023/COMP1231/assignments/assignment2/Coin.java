/* ===========================================================================
 * Coin.java
 * 
 * Tanner Watmough T00712721
 * COMP 1231 Assignment 2 Question 2
 * 
 * Represents a coin with two sides that can be flipped. Taken from
 * Java Foundations Introduction to Program Design and Data Structures 5E.
 * Modified to implement Lockable interface. 
 * ===========================================================================
 */

public class Coin implements Lockable {
  private final int HEADS = 0; // tails is 1

  private int face; // current side showing
  private int key; // The key value for Lockable.
  private boolean locked = false; // locked flag

  // Set up this coin by flipping it initially
  public Coin() {
    flip();
  }

  // Flips this coin by randomnly choosing a face value.
  public void flip() {
    // Can be locked since when Coin is first constructed, locked is false.
    if (!locked)
      face = (int) (Math.random() * 2);
  }

  // Returns true if current face of coin is heads
  public boolean isHeads() {
    // It seemed wrong to do the lock on this as a Boolean requires a true or
    // false value returned. A user/person won't know an object isn't returning
    // a valid value if we just return true or false when locked.
    return (face == HEADS);
  }

  // Return the current face of coin as a string
  public String toString() {
    // Not sure if locking was neccessary but it will return "Locked" when
    // locked.
    if (!locked)
      return (face == HEADS) ? "Heads" : "Tails";
    else
      return "Locked";
  }

  // Lockable Interface Methods

  // Sets key
  public void setKey(int genKey) {
    key = genKey;
  }

  // Locks methods
  public void lock(int pKey) {
    // Checks if passed key matches generated key.
    if (pKey == key) {
      // Checks if object is unlocked. If so, it locks it.
      if (!locked()) {
        locked = true;
      }
    }
  }

  // Unlocks methods
  public void unlock(int pKey) {
    // Checks if passed key matches generated key.
    if (pKey == key) {
      // Checks if object is already locked. If so, it unlocks it.
      if (locked()) {
        locked = false;
      }
    }
  }

  // Checks if object is currently locked
  public boolean locked() {
    // Return current lock state.
    return locked;
  }
}