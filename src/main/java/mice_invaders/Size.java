package mice_invaders;

public class Size {
  private int width;
  private int height;

  public Size() {
    width = 1;
    height = 1;
  }

  public Size(int _width, int _height) {
    width = _width;
    height = _height;
  }

  public Size(int length) {
    width = length;
    height = length;
  }

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }
}
