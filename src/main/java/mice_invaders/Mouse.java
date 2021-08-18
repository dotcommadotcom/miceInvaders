package mice_invaders;

import static mice_invaders.Direction.*;

public class Mouse extends Sprite {
  private Direction direction;
  private boolean hitBorder;

  public Mouse(Size _size, Coordinate _coordinate, int _speed) {
    super(_size, _coordinate, _speed);
    direction = RIGHT;
    hitBorder = false;
  }

  @Override
  public void moveVertical(Direction direction) {
    if (direction == DOWN) {
      coordinate.setY(coordinate.y() + direction.getValue() * size.height());
    }
  }

  @Override
  public void adjust(int amount) {
    super.adjust(amount);
    hitBorder = true;
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

  public boolean isBorderHit() {
    return hitBorder;
  }

  public void leaveBorder() {
    hitBorder = false;
  }
}
