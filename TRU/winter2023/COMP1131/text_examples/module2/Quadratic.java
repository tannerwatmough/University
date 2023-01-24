class Quadratic {
  public static void main(String[] args) {
    // 3X^2 - 8X +4

    double x = 0, result;

    for (int i = 0; i < 10; i++) {
      x = i;
      result = 3 * (x * x) - 8 * x + 4;
      System.out.println("At X = " + x + " the value is " + result);
    }

    x = 2.0 / 3.0;
    result = 3 * (x * x) - 8 * x + 4;
    System.out.println("At X = " + x + " the value is " + result);

    x = 1.0 / 3.0;
    result = 3 * (x * x) - 8 * x + 4;
    System.out.println("At X = " + x + " the value is " + result);

    x = 4.0 / 3.0;
    result = 3 * (x * x) - 8 * x + 4;
    System.out.println("At X = " + x + " the value is " + result);
  }
}
