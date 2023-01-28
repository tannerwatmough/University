import java.util.*;

class PasswordGenerator {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int digits = 0;

    // Ensures password is at least 5 characters long.
    while (digits < 5) {
      System.out.println("Your password must have at least 5 characters.");
      System.out.print("How many characters do you want in your password? ");
      digits = scan.nextInt();
    }

    // Gives lowercase and uppercase alphabet to choose from and then 0-9.
    String choices = "abcdefghijklmnopqrstuvwxyz";
    choices = choices + choices.toUpperCase(); // added to lowercase
    choices = choices + "1234567890";

    String password = "";
    int j = 0;
    // Adds a random character from the choices string and adds it to the
    // password. Repeat until you get a password of the desired digits length.
    while (j < digits) {
      password = password + choices.charAt(rand.nextInt(choices.length()));
      j = j + 1;
    }

    System.out.println("Here is your password: " + password);

    scan.close();
  }
}