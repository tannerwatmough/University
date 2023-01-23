// Words 2 demonstrates the use of the super reference
public class Words {
  // Instantiates a derived class and invokes its inherited and local methods
  public static void main(String[] args) {
    Dictionary webster = new Dictionary(1500, 52500);
    System.out.println("Number of pages: " + webster.getPages());
    System.out.println("Number of definitions: " + webster.getDefinitions());
    System.out.println("Definitions per page: " + webster.computeRatio());

    Dictionary meyers = new Dictionary(3500, 72500);
    System.out.println("Number of pages: " + meyers.getPages());
    System.out.println("Number of definitions: " + meyers.getDefinitions());
    System.out.println("Definitions per page: " + meyers.computeRatio());
  }
}