
// Get Degree
import java.util.Scanner;

public class DegreeType {
  private String degreeName;
  private static String[] degreeList = new String[] {
      "Certificate",
      "Associates Degree",
      "Bachelors Degree",
      "Masters Degree",
      "PhD"
  };
  int count = 1;

  public DegreeType() {
  }

  public void setDegree() {
    Scanner input = new Scanner(System.in);

    for (int i = 0; i < degreeList.length; i++) {
      System.out.println(count + ". " + degreeList[i]);
      count++;
    }

    System.out.print("Choose a degree level from the list: ");
    int selection = input.nextInt();
    String numtoselect = degreeList[selection - 1];
    System.out.println("The degree level you chose is: " + numtoselect);
    degreeName = numtoselect;
    input.close();
  }

  public String getDegreeName() {
    return degreeName;
  }

  public static void main(String[] args) {
    DegreeType degree = new DegreeType();

    degree.setDegree();

    System.out.println(degree.getDegreeName());
  }
}