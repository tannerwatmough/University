import java.util.Scanner;

public class Character {
  public static void main(String args[]) {
    String word;

    char letter;

    int aCount = 0, eCount = 0, iCount = 0;

    Scanner scan = new Scanner(System.in);

    System.out.print("Please enter a word");
    word = scan.next();
    word = word.toUpperCase();

    for (int i = 0; i < word.length(); i++) {
      switch (word.charAt(i)) {
        case 'A':
          aCount++;
          break;
        case 'E':
          eCount++;
          break;
        case 'I':
          iCount++;
          break;
        default:
          System.out.println("Error in Identification Character");
      }
    }
  }
}
