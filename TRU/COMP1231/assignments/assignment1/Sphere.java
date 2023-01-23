/*
 * Name: Tanner Watmough
 * Student ID: T00712721
 * Date: November 10, 2022
 * 
 * Program Name: Sphere.java
 * Program Purpose: Subclass of ThreeDShape that defines the 3D sphere shape and provides
 * its object constructor and methods.
 * Version 1.0
 */

public class Sphere extends ThreeDShape {
  private double radius;

  // Sphere Shape Constructor
  protected Sphere(double rad) {
    super();
    volume = volCalc(rad);
    surfaceArea = areaCalc(rad);
    radius = rad;
    shapeType = "Sphere";
  }

  // Sphere Volume Calculation
  private double volCalc(double rad) {
    vol = 1.3333 * Math.PI * Math.pow(rad, 3);
    return vol;
  }

  // Sphere Area Calculation
  private double areaCalc(double rad) {
    area = 4 * Math.PI * Math.pow(rad, 2);
    return area;
  }

  // Getter method for dimensions
  public double getDimensions() {
    dimensions = radius;
    return dimensions;
  }

  // Setter method for dimensions
  public void setDimensions(double newRadius) {
    radius = newRadius;
    volume = volCalc(radius);
    surfaceArea = areaCalc(radius);
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

  // Sphere toString()
  public String toString() {
    return super.toString() + ", Radius: " + radius;
  }

}
