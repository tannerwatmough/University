public class Point {

  public double x, y;

  public Point(double argsX, double argsY) {
    x = argsX;
    y = argsY;
  }

  public Point add(double oldX, double oldY, double changeInX, double changeInY) {
    x = oldX + changeInX;
    y = oldY + changeInY;

    return new Point(x, y);
  }

  public Point subtract(double oldX, double oldY, double changeInX, double changeInY) {
    x = oldX - changeInX;
    y = oldY - changeInY;

    return new Point(x, y);
  }

  public void show() {
    System.out.println("(" + x + ", " + y + ")");
  }

}