// SloganCounter.java
// Demonstrate the use of the static modifier. 

public class SloganCounter {
  // Create several Slogan objects and prints the number of objects that were
  // created
  public static void main(String[] args) {
    Slogan obj;

    obj = new Slogan("Remember the Alamo.");
    System.out.println(obj);

    obj = new Slogan("Don't Worry, Be Happy");
    System.out.println(obj);

    obj = new Slogan("Live Free or Die.");
    System.out.println(obj);

    System.out.println();
    System.out.println("Slogans created: " + Slogan.getCount());
  }
}