package mice_invaders;

public class Cat {
  private Dimension dimension;
  private int xCoordinate;
  private int yCoordinate;
  private int speed;

  public Cat(Dimension _dimension, Position _position) {
    this(_dimension, _position, 1);
  }

  public Cat(Dimension _dimension, Position _position, int _speed) {
    dimension = _dimension;
    xCoordinate = _position.x();
    yCoordinate = _position.y();
    speed = _speed;
  }

  public boolean isHere(int x, int y) {
    return x >= xCoordinate && x < xCoordinate + dimension.width()
            && y >= yCoordinate && y < yCoordinate + dimension.height();
  }

  public void moveRight() {
    xCoordinate += speed;
  }

  public void moveLeft() {
    xCoordinate -= speed;
  }

  public int getRightCorner() {
    return xCoordinate + dimension.width() - 1;
  }

  public int getLeftCorner() {
    return xCoordinate;
  }

  public int getSpeed() {
    return speed;
  }

  public int getWidth() {
    return dimension.width();
  }

  public void position(int _xCoordinate) {
    xCoordinate = _xCoordinate;
  }
}
