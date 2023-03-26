// Coin.java
// Represents a coin with two sides that can be flipped.

public class Coin {
  private final int HEADS = 0; // tails is 1

  private int face; // current side showing

  // Set up this coin by flipping it initially
  public Coin() {
    flip();
  }

  // Flips this coin by randomnly choosing a face value.
  public void flip() {
    face = (int) (Math.random() * 2);
  }

  // Returns true if current face of coin is heads
  public boolean isHeads() {
    return (face == HEADS);
  }

  // Return the current face of coin as a string
  public String toString() {
    return (face == HEADS) ? "Heads" : "Tails";
  }
}