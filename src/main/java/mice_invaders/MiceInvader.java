package mice_invaders;

public class MiceInvader
{
  public static final String CAT_MARK = "V";
  public static final String MISSILE_MARK = "M";
  public static final String EMPTY_MARK = ".";
  private final int arenaWidth;
  private final int arenaHeight;
  private Cat cat;
  private Missile missile;

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
    if(isCat(x, y)) {
      return CAT_MARK;
    } else if (isMissile(x, y)) {
      return MISSILE_MARK;
    }
    return EMPTY_MARK;
  }

  private boolean isMissile(int x, int y) {
    return missile != null && isSpriteHere(missile, x, y);
  }

  private boolean isCat(int x, int y) {
    return cat != null && isSpriteHere(cat, x, y);
  }

  private boolean isSpriteHere(Sprite sprite, int x, int y) {
    return x >= sprite.getLeft() && x < sprite.getRight() + 1 &&
            y < sprite.getBottom() + 1 && y >= sprite.getTop();
  }

  public void positionCat(Size size, Coordinate coordinate, int speed) throws RuntimeException {
    if (isOutsideArena(size.width(), size.height(), coordinate.x(), coordinate.y())) {
      throw new RuntimeException("Cat placed out of bounds.");
    }
    cat = new Cat(size, coordinate, speed);
  }

  boolean isOutsideArena(int width, int height, int x, int y) {
    return 0 > x || x + width > arenaWidth || 0 > y || y + height > arenaHeight;
  }

  public void moveCatRight() {
    if (cat.getRight() + cat.getSpeed() < arenaWidth) {
      cat.move(Direction.RIGHT);
    } else {
      cat.adjust(arenaWidth - cat.getWidth());
    }
  }

  public void moveCatLeft() {
    if (cat.getLeft() - cat.getSpeed() >= 0) {
      cat.move(Direction.LEFT);
    } else {
      cat.adjust(0);
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
    return new Coordinate(coordinateMissileX(size), coordinateMissileY(size));
  }

  private int coordinateMissileY(Size size) {
    return cat.getTop() - size.height();
  }

  private int coordinateMissileX(Size size) {
    return (cat.getWidth() - size.width()) / 2 + cat.getLeft();
  }

  public Cat getCat() {
    return cat;
  }

  public Missile getMissile() {
    return missile;
  }

  public void moveMissileUp() {
    missile.move(Direction.UP);
  }
}
