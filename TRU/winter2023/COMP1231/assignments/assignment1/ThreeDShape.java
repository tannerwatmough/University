/*
 * Name: Tanner Watmough
 * Student ID: T00712721
 * Date: November 10, 2022
 * 
 * Program Name: ThreeDShape.java
 * Program Purpose: Parent class of 3D shapes that provides the base constructor,
 * methods and variables for the subclasses Sphere.java, Cylinder.java, and Cube.java. 
 * Version 1.0
 */

import java.text.DecimalFormat;

public abstract class ThreeDShape {
  protected double vol, volume, area, surfaceArea, dimensions;
  protected String shapeType;

  // 3D Shape Constructor
  protected ThreeDShape() {

  }

  // Default Volume Calculation
  protected double volCalc() {
    return vol;
  }

  // Default Area Calculation
  protected double areaCalc() {
    return area;
  }

  // Getter method for dimensions
  public double getDimensions() {
    return dimensions;
  }

  // Setter method for dimensions
  public void setDimensions() {

  }

  /*
   * There is no setter methods for volume or area as this is dependent on the
   * dimensions set and
   * calculated in volCalc() and areaCalc().
   */

  // Getter method for volume
  public double getVolume() {
    return volume;
  }

  // Getter method for surface area
  public double getArea() {
    return surfaceArea;
  }

  // A decimal formatter so output is limited to 2 decimal places.

  protected static final DecimalFormat df = new DecimalFormat("0.00");

  // Default toString()
  public String toString() {
    return "Shape: " + shapeType + ", Volume: " + df.format(volume) + ", Surface Area: " + df.format(surfaceArea);
  }

}
