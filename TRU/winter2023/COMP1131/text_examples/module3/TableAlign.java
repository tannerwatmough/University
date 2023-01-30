import java.text.DecimalFormat;

class TableAlign {
  public static void main(String[] args) {
    double value = -90.0;
    DecimalFormat fmtAngle = new DecimalFormat(" 0.0;-0.0");
    DecimalFormat fmtSin = new DecimalFormat(" 0.0#####;-0.0#####");

    System.out.println("angle      sine");
    System.out.println("-----     -------");
    for (int i = 0; i < 13; i++) {
      if (value == 0) {
        System.out.println(" " + fmtAngle.format(value) + "\t    " +
            fmtSin.format(Math.sin(Math.toRadians(value))));
      } else {
        System.out.println(fmtAngle.format(value) + "\t    " +
            fmtSin.format(Math.sin(Math.toRadians(value))));
      }

      value += 15;
    }
  }
}