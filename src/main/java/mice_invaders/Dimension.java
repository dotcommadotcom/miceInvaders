package mice_invaders;

public class Dimension {
  private int width;
  private int height;

  public Dimension(int _width, int _height) {
    width = _width;
    height = _height;
  }
  public int width() {
    return width;
  }

  public int height() {
    return height;
  }
}