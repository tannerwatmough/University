import java.text.DecimalFormat;
import java.util.Scanner;

class RuleOf72 {
  public static void main(String[] args) {
    double interest, value;

    DecimalFormat fmt = new DecimalFormat("0.00");
    Scanner scan = new Scanner(System.in);

    System.out.println("How Long to Double Your Money");
    System.out.print("Enter the annual interest rate (without percent sign): ");
    interest = scan.nextDouble();

    value = 72.0 / interest;

    System.out.println("It will take " + fmt.format(value) + " year(s) to" +
        "double your money at an interest rate of " + interest);

    scan.close();
  }
}