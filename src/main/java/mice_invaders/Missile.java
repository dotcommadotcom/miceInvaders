package mice_invaders;

public class Missile extends Sprite {
  public Missile(Size _size, Coordinate _coordinate, int speed) {
    super(_size, _coordinate, speed);
  }

  @Override
  public void move(Direction direction) {
    coordinate.setY(coordinate.y() + direction.getValue() * speed);
  }

  @Override
  public void adjust(int amount) {

  }
}
