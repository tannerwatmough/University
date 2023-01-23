class Shortfall {
  public static void main(String[] args) {
    // short value = 32; this is fine
    // short value = 356;
    // value = 35000; results in incompatible types: possible lossy from
    // int to short.
    int value = 35000; // this will work
    System.out.println("A short: " + value);
  }
}