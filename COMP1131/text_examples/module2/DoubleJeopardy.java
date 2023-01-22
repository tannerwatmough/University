class DoubleJeopardy {
  public static void main(String[] args) {
    double value = 32;
    System.out.println("A double: " + value);
  }
}
// 32 should output similar to Shortfall but with a decimal place. 32.0
// 32.0 will have the same output of 32.0.
// 32E+1500 will break it. This gives the error that the floating point number
// is too large.