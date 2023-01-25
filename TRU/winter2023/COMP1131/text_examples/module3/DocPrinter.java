import java.util.Scanner;

public class DocPrinter {
  public static void main(String[] args) {
    String line = null;

    Scanner scan = new Scanner(System.in);

    while (scan.hasNext()) {
      line = scan.nextLine().trim();
      if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*")) {
        System.out.println(line);
      }
    }

    scan.close();

  }
}