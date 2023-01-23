import java.util.Scanner;

class HarmonicMean {
  public static void main(String[] args) {
    double x, y, mean, harMean;

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter X:");
    x = scan.nextDouble();
    System.out.println("Enter Y:");
    y = scan.nextDouble();

    mean = (y + x) / 2;
    harMean = 2.0 / (1 / x + 1 / y);

    System.out.println("Arithmetic mean: \t" + mean);
    System.out.println("Harmonic mean:   \t" + harMean);

    scan.close();
  }
}
