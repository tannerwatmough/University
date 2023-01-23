import java.util.Scanner;

class Gravity {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    final double GRAVITY = 32.174;
    double distance, time;

    System.out.print("Enter the number of seconds: ");
    time = scan.nextDouble();

    distance = (1.0 / 2.0) * GRAVITY * (time * time); // 1.0/2.0 float division

    System.out.println("Distance in feet: " + distance);

    scan.close();
  }
}
