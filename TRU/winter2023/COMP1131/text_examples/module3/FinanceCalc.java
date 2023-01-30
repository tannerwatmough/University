import java.text.DecimalFormat;
import java.util.Scanner;

class FinanceCalc {
  public static void main(String[] args) {
    // V = P(1 + r/n)^(n*t).
    double value, initDeposit, interest, years, calcFrequency;

    DecimalFormat fmt = new DecimalFormat("$0.00");
    Scanner scan = new Scanner(System.in);

    System.out.println("Interest Return Calculator");
    System.out.print("Initial deposit: ");
    initDeposit = scan.nextDouble();
    System.out.print("Interest rate (as fractional decimal): ");
    interest = scan.nextDouble();
    System.out.print("Times per year interest is calculated: ");
    calcFrequency = scan.nextDouble();
    System.out.print("Number of years: ");
    years = scan.nextDouble();

    value = initDeposit *
        Math.pow((1 + interest / calcFrequency), (calcFrequency * years));
    System.out.println("Value: " + fmt.format(value));

    scan.close();
  }
}