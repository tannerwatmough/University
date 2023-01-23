class Payroll {
  public static void main(String[] args) {
    long hoursWorked;
    double taxRate, payRate;

    hoursWorked = 40;
    payRate = 10.0;
    taxRate = 0.10;

    System.out.println("Hours Worked: " + hoursWorked);
    System.out.println("pay Amount  : " + (hoursWorked * payRate));
    System.out.println("tax Amount  : " + (hoursWorked * payRate * taxRate));
  }
}

/*
 * long hoursWorked = 40;
 * double payRate = 10.0, taxRate = 0.10;
 * System.out.println("Hours Worked: " + hoursWorked);
 * System.out.println("pay Amount  : " + (hoursWorked * payRate));
 * System.out.println("tax Amount  : " + (hoursWorked * payRate * taxRate));
 * 
 * Removing a declaration causes a compiler error (cannot find symbol which
 * is really pointing to the pissing type declaration).
 * 
 * Removing an initialization causes a variable might not have been initialized
 * compiler error.
 */