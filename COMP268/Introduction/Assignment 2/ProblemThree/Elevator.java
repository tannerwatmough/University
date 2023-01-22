/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Elevator.java
 * Program Purpose: Creates elevator objects and lets you set the storeys and floor the elevator 
 * is on.
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * The main program creates Elevators and updates their floor and storeys.
 * 
 * <H2> Elevator </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * This program will construct elevators with or without parameters with one of the constructors, set the 
 * instance variables of storeys and elevatorFloor. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Elevator.java</P>
 * <P>Run:        java Elevator</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Elevator is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Elevator Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method exceutes Problem 3's Elevator class. It creates elevators with one of the constructors, the default
 * constructor and one with the storeys set. It also calls the setElevatorFloor() and finalize() methods which will
 * set the floor and storeys of the building and destroy the object, resetting the elevator to floor one as it does so. 
 *</P>
 *<P>
 *  private Elevator() {<BR>
 * This is the default constructor which sets the storeys to 5 for the object and the elevator to the first floor.
 *</P>
  *<P>
 * private Elevator(int storeysArg) {<BR>
 * This is a constructor which sets the storeys to storeysArg for the object and the elevator to the first floor.
 *</P>
  *<P>
 * public void setElevatorFloor(int floorArg, int storeys) {<BR>
 * This is a setter method that sets the floor and the storeys for the object. It only lets you set
 * the floor to be within range of 1 to storeysArg. When calling this method, you should use the same
 * storeys as the Elevator object was constructed with but this isn't required.
 *</P>
  *<P>
 *  public String finalize() {<BR>
 * This method will garbage collect the elevator object and reset the elevator floor to the first floor. 
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Problem 3</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *  two elevator objects are created with two constructors, one that defaults to 5 storeys and one set to the argument
 *  storeys. setElevatorFloor() is called and sets the elevators to various floors and storeys and then calls the finalize()
 *  method on both elevator objects to garbage collect them.
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *  newElevator = new Elevator(); creates a new elevator object on floor 1 in a 5 storey building. 
 *  superElevator = new Elevator(100); creates a new elevator object on floor 1 in a 100 storey building.
 * ACTUAL:
 *  newElevator is created and can have setElevatorFloor() used on it and so is superElevator. It will set the floor
 *  to the entered value as long as it is lesser than the storeys of the building.
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   Setting the floor to higher than the storeys of the building will return an error message. 
 * ACTUAL:
 *   Setting the floors to greater than or equal to storeys prints an error saying that the floor
 *   does not exist and the elevator is returned to the first floor. 
 * </P>
 */

// CODE

public class Elevator {

  private int storeys, elevatorFloor;

  private Elevator() {
    storeys = 5;
    elevatorFloor = 1;
  }

  private Elevator(int storeysArg) {
    storeys = storeysArg;
    elevatorFloor = 1;
  }

  public void setElevatorFloor(int floorArg, int storeys) {
    if (floorArg <= storeys && floorArg >= 0) {
      elevatorFloor = floorArg;
      System.out.println("The elevator is now on floor " + floorArg + " of the building.");
    } else {
      System.out.println("Floor " + floorArg + " does not exist. Elevator returned to first floor.");
    }
  }

  public void finalize() {
    System.gc();
    elevatorFloor = 1;
    System.out.println("Elevator ending: elevator returned to the first floor.");
  }

  public static void main(String[] args) {
    // Scenario 1: Default Constructor for Elevator object
    Elevator newElevator = new Elevator();
    // Scenario 2: Setting custom storeys parameter for Elevator object.
    Elevator superElevator = new Elevator(100);

    // Scenario 3: Setting the elevator floor to 300 out of 400 storeys.
    superElevator.setElevatorFloor(300, 400);

    // Scenario 4: Setting floors out of bounds of storeys.
    newElevator.setElevatorFloor(7, 5);

    newElevator.setElevatorFloor(5, 5);

    newElevator.setElevatorFloor(-2, 10);

    // Scenario 5: Destroying the elevator and resetting to floor one.
    newElevator.finalize();

    superElevator.finalize();

  } // end of main

} // end of public class Elevator