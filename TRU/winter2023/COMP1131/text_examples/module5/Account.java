
// Account.java
// Represents an Account object.
import java.text.NumberFormat;

public class Account {
  private final double RATE = 0.035; // Interest rate of 3.5%

  private String name;
  private int accNumber;
  private double balance;

  // Create a new bank account
  public Account(String name, int accNumber, double balance) {
    this.name = name;
    this.accNumber = accNumber;
    this.balance = balance;
  }

  // Deposits money into an account
  public double deposit(double amount) {
    if (amount > 0) {
      balance = balance + amount;
    }

    return balance;
  }

  // Withdraw money from account
  public double withdraw(double amount, double transactionFee) {

    if (amount + transactionFee > 0 && amount + transactionFee < balance) {
      balance = balance - amount - transactionFee;
    }

    return balance;
  }

  // Interest payments
  public double addInterest() {
    balance += (balance * RATE);
    return balance;
  }

  public String toString() {
    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    return (accNumber + "\t" + name + "\t" + fmt.format(balance));
  }
}