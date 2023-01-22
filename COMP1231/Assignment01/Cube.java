public class Cube extends ThreeDShape {
  private double edge;

  // Cube Shape Constructor
  protected Cube(double a) {
    super();
    volume = volCalc(a);
    surfaceArea = areaCalc(a);
    edge = a;
    shapeType = "Cube";
  }

  // Cube Volume Calculation
  private double volCalc(double edg) {
    vol = Math.pow(edg, 3);
    return vol;
  }

  // Cube Area Calculation
  private double areaCalc(double edg) {
    area = 6 * Math.pow(edg, 2);
    return area;
  }

  // Getter method for dimensions
  public double getDimensions() {
    dimensions = edge;
    return dimensions;
  }

  // Setter method for dimensions
  public void setDimensions(double newEdge) {
    edge = newEdge;
    volume = volCalc(newEdge);
    surfaceArea = areaCalc(newEdge);
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

  // Cube toString()
  public String toString() {
    return super.toString() + ", Edge Length: " + edge;
  }

}
