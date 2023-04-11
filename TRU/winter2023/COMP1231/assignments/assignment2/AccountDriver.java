/* ===========================================================================
 * AccountDriver.java
 * 
 * Tanner Watmough T00712721
 * COMP 1231 Assignment 2 Question 2
 * 
 * This is a simple driver for the Account class. It creates various Accounts 
 * that are locked and unlocked to see if the methods work or not.  
 * ===========================================================================
 */

public class AccountDriver {
  public static void main(String[] args) {
    // Create two new account objects.
    Account acc1 = new Account("John Lewis", 75532, 50.75);
    Account acc2 = new Account("Ben Franklin", 49927, 50358.22);

    // Set different keys for both accounts.
    acc1.setKey(10);
    acc2.setKey(15);

    // Test various methods on object to make sure base function is working.
    acc1.deposit(49.25);
    System.out.println("Account 1 deposit...");
    System.out.println(acc1);
    acc1.withdraw(98.00, 1.00);
    System.out.println("Account 1 withdrawal...");
    System.out.println(acc1);
    acc1.addInterest();
    System.out.println("Account 1 interest payment...");
    System.out.println(acc1);

    System.out.println();

    // Locking object and testing the various methods again.
    acc1.lock(10);
    acc1.deposit(100.25);
    System.out.println("Account 1 deposit... (locked)");
    System.out.println(acc1);
    acc1.withdraw(98.00, 1.00);
    System.out.println("Account 1 withdrawal... (locked)");
    System.out.println(acc1);
    acc1.addInterest();
    System.out.println("Account 1 interest payment... (locked)");
    System.out.println(acc1);

    System.out.println();

    // Showing lock is independent of other objects.
    acc2.deposit(5000.25);
    System.out.println("Account 2 deposit...");
    System.out.println(acc2);
    System.out.println("Acc 1 is Locked: " + acc1.locked());
    acc2.withdraw(25000.00, 1.00);
    System.out.println("Account 2 withdrawal...");
    System.out.println(acc2);
    System.out.println("Account 2 interest payment...");
    acc2.addInterest();
    System.out.println(acc2);

    System.out.println();

    // Showing use of acc1 key for acc2 and it not working.
    acc2.lock(10); // same key as acc1 but supposed to be 15.
    System.out.println("Acc 2 is Locked: " + acc2.locked());
    acc2.withdraw(25000.00, 1.00);
    System.out.println("Account 2 withdrawal...");
    System.out.println(acc2);

    System.out.println();

    // Showing that unlock works as well
    acc1.unlock(10);
    System.out.println("Unlocked Account 1...");
    acc1.deposit(25000);
    System.out.println("Account 1 deposit...");
    System.out.println(acc1);
  }
}