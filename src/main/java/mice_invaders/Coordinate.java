package mice_invaders;

public class Coordinate {
  private int x;
  private int y;

  public Coordinate(int _x, int _y) {
    x = _x;
    y = _y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public void setX(int _x) {
    x = _x;
  }

  public void setY(int _y) {
    y = _y;
  }
}
