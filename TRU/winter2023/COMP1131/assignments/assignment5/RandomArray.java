/* ===========================================================================
 * RandomArray.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 5 Question 1
 * 
 * This file defines the RandomArray class including the constructor, and the
 * minValue(), maxValue(), averageValue(), and toString() methods. 
 * 
 * RandomArray(int size)
 * Constructs an array with a length equal to the passed parameter size. It then
 * populates the entire array with random values between 0 and the passed size
 * value (inclusive). 
 * 
 * minValue()
 * Compares values in array to find the smallest number in the array.
 * 
 * maxValue()
 * Compares values in array to find the largest number in the array.
 * 
 * averageValue()
 * Sums all values in array and divides by the array length (total number of 
 * items in array) to get the array average. 
 * 
 * toString()
 * Outputs the index and value of each array item to a string value. 
 * 
 * ===========================================================================
 */

public class RandomArray {
  private int[] array;

  // RandomArray constructor takes in size as parameter and generates random
  // numbers from 0 to the value of size (inclusive) for each array index.
  public RandomArray(int size) {
    array = new int[size];
    for (int i = 0; i < array.length; i++) {
      array[i] = (int) (Math.random() * (size + 1));
    }
  }

  // Sets min value to first value in array and sequentially compares that value
  // until a value is less than it which becomes new min. That is then compared
  // to remainder of array, changed if there's a lesser value, until there is
  // no array left. oldValues > oldMin > newMin
  public int minValue() {
    int min = array[0];

    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }

    return min;

  }

  // Same process as min where first value in array is compared to other values.
  // Any value greater becomes new max and gets compared to next values in array
  // until there are no values left. No need to compare to previous values as
  // oldValue < oldMax < newMax
  public int maxValue() {
    int max = array[0];

    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }

    return max;
  }

  // Running sum of all array values which is divided by total length.
  public double averageValue() {
    double average = 0.0;

    for (int i = 0; i < array.length; i++) {
      average += array[i];
    }

    average /= array.length;

    return average;
  }

  // Prints out index position and value for each value in array.
  public String toString() {
    String result = "";
    int indexCount = 0;
    final int COL_COUNT = 5;
    int maxRows = (array.length / COL_COUNT);
    int valuesLeft = array.length;

    // Done so arrays not divisible by COL_COUNT get an extra row to print to.
    if (array.length % COL_COUNT != 0) {
      maxRows++;
    }

    for (int rows = 0; rows < maxRows; rows++) {
      // Prevent index error for last row
      if (valuesLeft > COL_COUNT) {
        for (int cols = 0; cols < COL_COUNT; cols++) {
          valuesLeft--;
          result += "Index " + indexCount + ": " + array[indexCount] + "\t";
          indexCount++;
        }
      } else {
        // valuesLeft will always be COL_COUNT or less so last row prints right.
        for (int cols = 0; cols < valuesLeft; cols++) {
          result += "Index " + indexCount + ": " + array[indexCount] + "\t";
          indexCount++;
        }
      }
      // Starts a new row line for array values.
      result += "\n";
    }

    return result;
  }
}