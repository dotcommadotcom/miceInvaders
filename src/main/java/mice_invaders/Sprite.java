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

  public void moveHorizontal(Direction direction) {
    coordinate.setX(coordinate.x() + direction.getValue() * speed);
  }

  public void moveVertical(Direction direction) {
    coordinate.setY(coordinate.y() + direction.getValue() * speed);
  }

  public void adjust(int amount) {
    coordinate.setX(amount);
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

  public boolean isHere(int x, int y) {
    return x >= getLeft() && x < getRight() + 1 && y < getBottom() + 1 && y >= getTop();
  }

}

