/*
 * Name: Tanner Watmough
 * Student ID: T00712721
 * Date: November 10, 2022
 * 
 * Program Name: Cylinder.java
 * Program Purpose: Subclass of ThreeDShape that defines the 3D cylinder shape and provides
 * its object constructor and methods.
 * Version 1.0
 */

public class Cylinder extends ThreeDShape {
  private double radius, height;

  // Cylinder Shape Constructor
  protected Cylinder(double rad, double hgt) {
    super();
    volume = volCalc(rad, hgt);
    surfaceArea = areaCalc(rad, hgt);
    height = hgt;
    radius = rad;
    shapeType = "Cylinder";
  }

  // Cylinder Volume Calculation
  private double volCalc(double rad, double hgt) {
    vol = Math.PI * Math.pow(rad, 2) * hgt;
    return vol;
  }

  // Cylinder Area Calculation
  private double areaCalc(double rad, double hgt) {
    area = 2 * Math.PI * rad * hgt + 2 * Math.PI * Math.pow(rad, 2);
    return area;
  }

  // Getter methods for dimensions
  public double getRadius() {
    dimensions = radius;
    return dimensions;
  }

  public double getHeight() {
    dimensions = height;
    return dimensions;
  }

  // Setter method for dimensions
  public void setDimensions(double newRadius, double newHeight) {
    height = newHeight;
    radius = newRadius;
    surfaceArea = areaCalc(radius, height);
    volume = volCalc(radius, height);
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

  // Cylinder toString()
  public String toString() {
    return super.toString() + ", Radius: " + radius + ", Height: " + height;
  }

}
