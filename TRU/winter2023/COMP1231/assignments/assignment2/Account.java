/* ===========================================================================
 * Account.java
 * 
 * Tanner Watmough T00712721
 * COMP 1231 Assignment 2 Question 2
 * 
 * Represents a Bank Account object. Taken from
 * Java Foundations Introduction to Program Design and Data Structures 5E.
 * Modified to implement Lockable interface. 
 * ===========================================================================
 */

import java.text.NumberFormat;

public class Account implements Lockable {
  private final double RATE = 0.035; // Interest rate of 3.5%

  private String name;
  private int accNumber;
  private double balance;

  private int key; // The key value for Lockable.
  private boolean locked = false; // locked flag

  // Create a new bank account
  public Account(String name, int accNumber, double balance) {
    this.name = name;
    this.accNumber = accNumber;
    this.balance = balance;
  }

  // Deposits money into an account if deposit value greater than 0.
  public double deposit(double amount) {
    if (!locked) {
      if (amount > 0) {
        balance = balance + amount;
      }
    }

    return balance;
  }

  // Withdraw money from account if there's sufficient funds.
  public double withdraw(double amount, double transactionFee) {
    if (!locked) {
      if (amount + transactionFee > 0 && amount + transactionFee < balance) {
        balance = balance - amount - transactionFee;
      }
    }

    return balance;
  }

  // Interest payments
  public double addInterest() {
    if (!locked) {
      balance += (balance * RATE);
    }
    return balance;
  }

  // toString method for normalized string output.
  public String toString() {
    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    return (accNumber + "\t" + name + "\t" + fmt.format(balance));
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