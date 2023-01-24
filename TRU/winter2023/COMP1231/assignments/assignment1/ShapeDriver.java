/*
 * Name: Tanner Watmough
 * Student ID: T00712721
 * Date: November 10, 2022
 * 
 * Program Name: ShapeDriver.java
 * Program Purpose: Runs the program and its tests for initiating the 3D shapes and displays their
 * dimensions, volume, and surface area. 
 * Version 1.0
 */

public class ShapeDriver {
  public static void main(String[] args) {
    /*
     * "Normal" values, upper bound, and lower bound values initalized for the three
     * object types.
     */

    // Sphere Object Initiation
    Sphere sphere1 = new Sphere(5);
    Sphere sphere2 = new Sphere(300000000);
    Sphere sphere3 = new Sphere(-300000000);

    // Cylinder Object Initiation
    Cylinder cylinder1 = new Cylinder(5, 10);
    Cylinder cylinder2 = new Cylinder(300000000, 30000000);
    Cylinder cylinder3 = new Cylinder(-300000000, -30000000);

    // Cube Object Initiation
    Cube cube1 = new Cube(5);
    Cube cube2 = new Cube(300000000);
    Cube cube3 = new Cube(-300000000);

    // All Objects Test Display
    System.out.println("Object Iniitalized Test");
    System.out.println(sphere1.toString());
    System.out.println(sphere2.toString());
    System.out.println(sphere3.toString());
    System.out.println(cylinder1.toString());
    System.out.println(cylinder2.toString());
    System.out.println(cylinder3.toString());
    System.out.println(cube1.toString());
    System.out.println(cube2.toString());
    System.out.println(cube3.toString());
    System.out.println();

    // Sphere getter and setter tests
    System.out.println("Sphere Tests");
    System.out.println(sphere1.getDimensions());
    System.out.println(sphere1.getVolume());
    System.out.println(sphere1.getArea());
    System.out.println(sphere1.toString());

    sphere1.setDimensions(10);
    System.out.println(sphere1.getDimensions());
    System.out.println(sphere1.getVolume());
    System.out.println(sphere1.getArea());
    System.out.println(sphere1.toString());
    System.out.println();

    // Cube getter and setter tests
    System.out.println("Cube Tests");
    System.out.println(cube1.getDimensions());
    System.out.println(cube1.getVolume());
    System.out.println(cube1.getArea());
    System.out.println(cube1.toString());

    cube1.setDimensions(10);
    System.out.println(cube1.getDimensions());
    System.out.println(cube1.getVolume());
    System.out.println(cube1.getArea());
    System.out.println(cube1.toString());
    System.out.println();

    // Cylinder getter and setter tests
    System.out.println("Cylinder Tests");
    System.out.println(cylinder1.getRadius());
    System.out.println(cylinder1.getHeight());
    System.out.println(cylinder1.getVolume());
    System.out.println(cylinder1.getArea());
    System.out.println(cylinder1.toString());

    cylinder1.setDimensions(10, 15);
    System.out.println(cylinder1.getRadius());
    System.out.println(cylinder1.getHeight());
    System.out.println(cylinder1.getVolume());
    System.out.println(cylinder1.getArea());
    System.out.println(cylinder1.toString());
    System.out.println();
  }
}
