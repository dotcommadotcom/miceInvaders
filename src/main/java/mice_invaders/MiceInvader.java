package mice_invaders;

import mice_invaders.gui.Commons;

import static mice_invaders.Direction.*;
import static mice_invaders.gui.Commons.*;

public class MiceInvader {
  private final int arenaWidth;
  private final int arenaHeight;
  private Cat cat;
  private Missile missile;
  private Mouse mouse;

  public MiceInvader(int _arenaWidth, int _arenaHeight) {
    arenaWidth = _arenaWidth;
    arenaHeight = _arenaHeight;
  }

  @Override
  public String toString() {
    StringBuilder boardArea = new StringBuilder();
    for (int i = 0; i < arenaHeight; i++) {
      for (int j = 0; j < arenaWidth; j++) {
        boardArea.append(getMark(j, i));
      }
      boardArea.append("\n");
    }
    return boardArea.toString();
  }

  private String getMark(int x, int y) {
    if(isSpriteHere(cat, x, y)) {
      return CAT_MARK;
    } else if (isSpriteHere(missile, x, y)) {
      return MISSILE_MARK;
    } else if (isSpriteHere(mouse, x, y)) {
      return MOUSE_MARK;
    }
    return EMPTY_MARK;
  }

  private boolean isSpriteHere(Sprite sprite, int x, int y) {
    return sprite != null && sprite.isHere(x, y);
  }

  public Cat getCat() {
    return cat;
  }

  public Missile getMissile() {
    return missile;
  }

  public Mouse getMouse() { return mouse;
  }

  public void positionCat(Size size, Coordinate coordinate, int speed) throws RuntimeException {
    checkArenaBoundary(size, coordinate, "Cat");

    cat = new Cat(size, coordinate, speed);
  }

  public void moveSpriteInDirection(Sprite sprite, Direction direction) {
    if (direction == RIGHT) {
      moveSpriteRight(sprite);
    } else if (direction == LEFT) {
      moveSpriteLeft(sprite);
    } else if (direction == UP) {
      sprite.moveVertical(UP);
    } else if (direction == DOWN) {
      sprite.moveVertical(DOWN);
    }
  }

  private void moveSpriteRight(Sprite sprite) {
    if (sprite.getRight() + sprite.getSpeed() < arenaWidth) {
      sprite.moveHorizontal(RIGHT);
    } else {
      sprite.adjust(arenaWidth - sprite.getWidth());
    }
  }

  private void moveSpriteLeft(Sprite sprite) {
    if (sprite.getLeft() - sprite.getSpeed() >= 0) {
      sprite.moveHorizontal(LEFT);
    } else {
      sprite.adjust(0);
    }
  }

  public void shootMissile(Size size, int speed) {
    if (isMissileWiderThanCat(size)) {
      throw new RuntimeException("Missile is wider than cat.");
    }

    if (isMissileTooHigh(size)) {
      throw new RuntimeException("Missile is too high for arena.");
    }

    missile = new Missile(size, coordinateMissile(size), speed);
  }

  private boolean isMissileTooHigh(Size size) {
    return size.height() + cat.getHeight() > arenaHeight;
  }

  private boolean isMissileWiderThanCat(Size size) {
    return size.width() > cat.getWidth();
  }

  private Coordinate coordinateMissile(Size size) {
    return new Coordinate((cat.getWidth() - size.width()) / 2 + cat.getLeft(),
            cat.getTop() - size.height());
  }

  public void positionMouse(Size size, Coordinate coordinate, int speed) throws RuntimeException {
    checkArenaBoundary(size, coordinate, "Mouse");

    mouse = new Mouse(size, coordinate, speed);
  }

  public void moveMouse() {
    if (mouse.isBorderHit()) {
      moveSpriteInDirection(mouse, DOWN);
      mouse.leaveBorder();
    } else {
      moveSpriteInDirection(mouse, mouse.getDirection());
    }
  }

  private void checkArenaBoundary(Size size, Coordinate coordinate, String sprite) {
    if (isOutsideArena(size.width(), size.height(), coordinate.x(), coordinate.y())) {
      throw new RuntimeException(sprite + " placed out of bounds.");
    }
  }

  boolean isOutsideArena(int width, int height, int x, int y) {
    return 0 > x || x + width > arenaWidth || 0 > y || y + height > arenaHeight;
  }

  public boolean detectCollision(Sprite firstSprite, Sprite secondSprite) {
    return overlapX(firstSprite, secondSprite) && overlapY(firstSprite, secondSprite);
  }

  private boolean overlapY(Sprite firstSprite, Sprite secondSprite) {
    return firstSprite.getTop() <= secondSprite.getBottom() + 1
            && firstSprite.getBottom() + 1 >= secondSprite.getTop();
  }

  private boolean overlapX(Sprite firstSprite, Sprite secondSprite) {
    return firstSprite.getRight() + 1 >= secondSprite.getLeft()
            && firstSprite.getLeft() <= secondSprite.getRight() + 1;
  }
}
