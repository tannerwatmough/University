// ****************************************************************************
// Ohm.java    Java Foundations
//
// Ohm's Law relates to resistance of electrical device to the electric current 
// flowing through the device and the voltage applied to it.
// The law is I = V/R  
// - V is voltage (measured in volts)
// - I is the current (measured in amps)
// - R is the resistance (measured in ohms).
// 
// The program prompts users for voltage and resistance of a device and 
// calculates the current flowing through the device. 
// ****************************************************************************

import java.util.Scanner;

public class Ohm {
  public static void main(String[] args) {
    int voltage, resistance;
    double current;

    Scanner scan = new Scanner(System.in);

    System.out.print("Enter the voltage (in volts) of the device: ");
    voltage = scan.nextInt();

    System.out.print("Enter the resistance (in ohms) of the device: ");
    resistance = scan.nextInt();

    // Due to integer division, we must convert to floating point using a trick.
    current = (voltage + 0.00) / resistance;

    System.out.println("The current is: " + current + " amps.");

    scan.close();
  }
}