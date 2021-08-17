package mice_invaders;

import static mice_invaders.Direction.*;

public class Mouse extends Sprite {
  private Direction direction;

  public Mouse(Size _size, Coordinate _coordinate, int _speed) {
    super(_size, _coordinate, _speed);
    direction = RIGHT;
  }

  @Override
  public void move(Direction direction) {
    coordinate.setX(coordinate.x() + direction.getValue() * speed);
  }

  @Override
  public void adjust(int amount) {
    coordinate.setX(amount);
    toggleDirection();
  }

  private void toggleDirection() {
    if (direction == RIGHT) {
      direction = LEFT;
    } else if (direction == LEFT) {
      direction = RIGHT;
    }
  }

  public Direction getDirection() {
    return direction;
  }
}
