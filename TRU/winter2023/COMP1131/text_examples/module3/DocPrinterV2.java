/* ============================================================================
 * DocPrinterV2.java
 * Author: Tanner Watmough
 * 
 * This program will scan any .java files and output any program comments to
 * the console for viewing. It handles both single-line (//) and multi-line (/*) 
 * comments. 
 * ============================================================================
 */

import java.util.Scanner;

public class DocPrinterV2 {
  public static void main(String[] args) {
    String line = null;
    boolean print = false;

    Scanner scan = new Scanner(System.in);
    // Will scan a file so long as there's something in the scanner queue
    while (scan.hasNext()) {
      line = scan.nextLine().trim();

      if (line.startsWith("//")) {
        System.out.println(line);
      }

      if (line.startsWith("/*")) {
        print = true;
      }

      if (print) {
        System.out.println(line);
      }

      if (line.startsWith("*/")) {
        print = false;
      }
    }

    scan.close();

  }
}