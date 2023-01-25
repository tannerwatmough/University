import java.util.Scanner;

public class StringChar {
  public static void main(String[] args) {
    String userInput;

    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter a string: ");
    userInput = scan.nextLine();

    for (int i = 0; i < userInput.length(); i++) {
      System.out.println(userInput.charAt(i));
    }

    scan.close();

  }
}