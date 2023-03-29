/* ===========================================================================
 * Bug.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 4 Question 1
 * 
 * This is the Bug class. It defines movement, direction, the constructor, and
 * toString method of a Bug object moving in relation to the 2D plane.  
 * ===========================================================================
 */

public class Bug {
  // Private methods so they can't be manipulated from outside the object.
  private int pos;
  private boolean direction = true;

  // Constructor. Places bug on wire in a random position from -99 to 99
  public Bug() {
    // Generates random number from 0 to 99.
    pos = (int) (Math.random() * 100);
    // Generates second random number. Half the time it'll multiply the pos
    // value to be negative instead.
    if (Math.random() < 0.5) {
      pos = pos * -1;
    }

    // Randomizes direction bug races when landing on wire. Math.random() should
    // be greater than 0.5 half the time. When it is, direction evaluates to
    // true which in turn means the Bug is facing right. Otherwise, it evaluates
    // to false and the direction is false, meaning the Bug is facing left.
    direction = (0.5 < Math.random());
  }

  // Depending on direction, will move the Bug by one unit on the x-axis.
  public void move() {
    // If direction is true or right, increment (move right).
    if (direction) {
      pos++;
    }
    // Otherwise, direction is left, decrement (move left).
    else {
      pos--;
    }
  }

  // Sets direction to opposite value.
  public void turn() {
    direction = !direction;
  }

  // Setter method for position
  public void setPosition(int pos) {
    this.pos = pos;
  }

  // Getter method for position. Not used in Driver program.
  public int getPosition() {
    return pos;
  }

  // Displays command line ASCII art as a graphical representation of the
  // bug object's current position and direction its facing.
  public void graphicOutput() {
    System.out.println();
    System.out.print("Position: " + pos + "   Direction: ");
    if (direction) {
      // If right, bug's antenna faces right
      System.out.println("Right");
      System.out.println("     o'    ");
    } else {
      // If left, bug's antenna faces left
      System.out.println("Left");
      System.out.println("    'o     ");
    }
    // Represents the wire
    System.out.println("-----------");
    // Gives positions five to the left and five to the right of current.
    System.out.println((pos - 5) + "\t " + (pos + 5));
  }

  // Provides useful output when a Bug object is converted to String showing
  // current direction the Bug object is facing and its current position on the
  // x-axis or "wire".
  public String toString() {
    String result = "Bug is facing ";

    // Since direction is a Boolean, we need to convert to the String value.
    if (direction) {
      result += "right. ";
    } else {
      result += "left. ";
    }

    result += "Current position is " + pos;

    return result;
  }

}