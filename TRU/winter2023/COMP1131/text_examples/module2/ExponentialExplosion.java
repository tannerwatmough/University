class ExponentialExplosion {
  public static void main(String[] args) {
    double value = 709;
    System.out.println("e to the power value: " + Math.exp(value));
  }
}

// 32 as initial value is fine.
// Eventually outputs Infinity instead of a number.
// 709 is the limit. 710 will push it into Infinity.