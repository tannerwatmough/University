import java.util.Scanner;

public class TitlePrefix {
  public static void main(String[] args) {
    String userInput = "";

    Scanner scan = new Scanner(System.in);

    while (userInput.length() < 1) {
      System.out.println("Enter a name: ");
      userInput = scan.nextLine();

      if (userInput.startsWith("Amy") || userInput.startsWith("Buffy") ||
          userInput.startsWith("Cathy")) {
        System.out.println("Ms. " + userInput);
      } else if (userInput.startsWith("Elroy") || userInput.startsWith("Fred") ||
          userInput.startsWith("Graham")) {
        System.out.println("Mr. " + userInput);
      } else {
        System.out.println(userInput);
      }
    }

    scan.close();
  }
}