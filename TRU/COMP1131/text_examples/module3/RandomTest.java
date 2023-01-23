import java.util.Random;

public class RandomTest {
  public static void main(String[] args) {
    Random randomizer = new Random();

    int num1, num2, num3;

    num1 = randomizer.nextInt(300);
    num3 = randomizer.nextInt(20) - 10; // -10 to 9

    System.out.println(num1);
    System.out.println(num3);

    for (int i = 0; i < 100; i++) {
      num2 = randomizer.nextInt(5) + 1;
      System.out.println(num2);
    }
  }
}