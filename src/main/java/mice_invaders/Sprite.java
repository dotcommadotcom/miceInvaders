package mice_invaders;

public abstract class Sprite {
  Size size;
  Coordinate coordinate;
  int speed;

  public Sprite(Size _size, Coordinate _coordinate, int _speed) {
    size = _size;
    coordinate = _coordinate;
    speed = _speed;
  }

  public void moveRight() {
    coordinate.setX(coordinate.x() + speed);
  }

  public void moveLeft() {
    coordinate.setX(coordinate.x() - speed);
  }

  public void position(int _xCoordinate) {
    coordinate.setX(_xCoordinate);
  }

  public int getRight() {
    return coordinate.x() + size.width() - 1;
  }

  public int getLeft() {
    return coordinate.x();
  }

  public int getBottom() {
    return coordinate.y() + size.height() - 1;
  }

  public int getTop() {
    return coordinate.y();
  }

  public int getSpeed() {
    return speed;
  }

  public int getWidth() {
    return size.width();
  }

  public int getHeight() {
    return size.height();
  }

}