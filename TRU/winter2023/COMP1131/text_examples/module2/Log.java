import java.util.Scanner;

class Log {
  public static void main(String[] args) {
    double userInput, result;

    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter a number for it's base 2 log: ");
    userInput = scan.nextDouble();

    // log2 X = (log_e X) / (log_e 2) since Java lacks Math.log2()
    result = (Math.log(userInput)) / (Math.log(2));

    System.out.println("Base 2 log of " + userInput + " is " + result);

    scan.close();
  }
}