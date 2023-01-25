import java.util.Scanner;

public class Echo {
  public static void main(String[] args) {
    // Asks for user's name, prints back first name as entered and second name
    // in all capitals. Assume there are two names separated by a space. You
    // need to remove leading spaces using .trim().
    String userFirst, userLast;

    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter your first and last name separated by a"
        + " space");
    userFirst = scan.next();
    userFirst = userFirst.trim();

    userLast = scan.next();
    userLast = userLast.trim().toUpperCase();

    System.out.println(userFirst + " " + userLast);

    scan.close();
  }
}