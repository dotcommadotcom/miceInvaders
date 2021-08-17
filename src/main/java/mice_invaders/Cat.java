package mice_invaders;

public class Cat extends Sprite {

  public Cat(Size _size, Coordinate _coordinate, int _speed) {
    super(_size, _coordinate, _speed);
  }

  @Override
  public void move(Direction direction) {
    coordinate.setX(coordinate.x() + direction.getValue() * speed);
  }

  @Override
  public void adjust(int amount) {
    coordinate.setX(amount);
  }

}
