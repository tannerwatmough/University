import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Currency;

class Electricity {
  public static void main(String[] args) {
    double kwhCost, kwh, annualCost;

    Scanner scan = new Scanner(System.in);
    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    // Set currency to Canadian Dollar
    fmt.setCurrency(Currency.getInstance(Locale.CANADA));

    System.out.print("Enter cost per kilowatt-hour in cents: ");
    kwhCost = scan.nextDouble();
    System.out.print("Enter kilowatt-hours used per year: ");
    kwh = scan.nextDouble();

    annualCost = (kwhCost * kwh) / 100;
    System.out.println("Annual cost (in dollars): " + fmt.format(annualCost));

    scan.close();
  }
}
