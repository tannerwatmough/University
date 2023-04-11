/* ===========================================================================
 * CoinDriver.java
 * 
 * Tanner Watmough T00712721
 * COMP 1231 Assignment 2 Question 2
 * 
 * This is a simple driver for the Coin class. It creates various coins that are
 * locked and unlocked to see if the methods work or not.  
 * ===========================================================================
 */

public class CoinDriver {
  public static void main(String[] args) {
    Coin coin1 = new Coin();

    // Sets key to int 5.
    coin1.setKey(5);

    // Flips the coin to make sure its working and prints out the result.
    coin1.flip();
    System.out.println(coin1.toString());

    // Locks the coin with the correct key and displays if its locked and what
    // happens when you try to flip it.
    coin1.lock(5);
    System.out.println("Locked: " + coin1.locked());
    coin1.flip();
    System.out.println(coin1.toString());

    // Unlocks the coin to show the methods once again work and no longer locked.
    coin1.unlock(5);
    System.out.println("Locked: " + coin1.locked());
    coin1.flip();
    System.out.println(coin1.toString());

    // Tries locking with wrong key. Shows it did not lock.
    coin1.lock(3);
    System.out.println("Locked: " + coin1.locked());

    // Locks it with the correct key. Shows it did lock again.
    coin1.lock(5);
    System.out.println("Locked: " + coin1.locked());

    // Tries unlocking with wrong key. Shows it stays locked.
    coin1.unlock(3);
    System.out.println("Locked: " + coin1.locked());
  }
}