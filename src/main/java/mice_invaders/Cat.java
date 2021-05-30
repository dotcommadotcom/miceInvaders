package mice_invaders;

public class Cat {
  private final Dimension dimension;
  private int xCoordinate;
  private int yCoordinate;

  public Cat(Dimension _dimension, Position _position) {
    dimension = _dimension;
    xCoordinate = _position.x();
    yCoordinate = _position.y();
  }

  public boolean isHere(int x, int y) {
    return x >= xCoordinate && x < xCoordinate + dimension.width()
            && y >= yCoordinate && y < yCoordinate + dimension.height();
  }

  public void moveRight() {
    xCoordinate++;
  }

  public void moveLeft() {
    xCoordinate--;
  }

  public int getRightCorner() {
    return xCoordinate + dimension.width();
  }

  public int getLeftCorner() {
    return xCoordinate;
  }
}
