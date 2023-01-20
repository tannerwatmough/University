import java.util.Scanner;

public class TechTree {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] researchList = new String[] {
        "Woodworking",
        "Pottery",
        "Astronomy"
    };
    boolean exit = false;
    int tree1 = 0, tree2 = 0, tree3 = 0;

    while (!exit) {
      System.out.println("Choose a research option: ");
      System.out.println("1. " + researchList[0]);
      System.out.println("2. " + researchList[1]);
      System.out.println("3. " + researchList[2]);
      int researchChoice = input.nextInt();

      System.out.println("You chose " + researchList[researchChoice - 1]);

      if (researchChoice == 1) {
        researchList[0] = "Construction";
        tree1++;
        if (tree1 > 1) {
          researchList[0] = "XXXXX";
        }
        System.out.println(tree1);
      }

      if (researchChoice == 2) {
        researchList[1] = "Bricks";
        tree2++;
        if (tree2 > 1) {
          researchList[1] = "XXXXX";
        }
        System.out.println(tree2);
      }

      if (researchChoice == 3) {
        researchList[2] = "Space Travel";
        tree3++;
        if (tree3 > 1) {
          researchList[2] = "XXXXX";
        }
        System.out.println(tree3);
      }

      if (researchList[0].toString().equals("XXXXX") &&
          researchList[1].toString().equals("XXXXX") &&
          researchList[2].toString().equals("XXXXX")) {
        exit = true;
      }
    }

    input.close();
  }
}