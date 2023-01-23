import java.util.Scanner;

class ColumnCheck {
  public static void main(String[] args) {
    final int colNum = 10;
    int counter = 0;
    String line = null;
    Scanner scan = new Scanner(System.in);

    while (scan.hasNext()) {
      line = scan.nextLine();
      counter = counter + 1;
      if (line.length() > colNum && line.charAt(colNum) != ' ')
        System.out.println(counter + ":\t" + line);
    }

    scan.close();
  }
}