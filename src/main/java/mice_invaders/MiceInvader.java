package mice_invaders;

public class MiceInvader {
  private final int arenaWidth;
  private final int arenaHeight;
  private Cat cat;

  public MiceInvader(int _arenaWidth, int _arenaHeight) {
    arenaWidth = _arenaWidth;
    arenaHeight = _arenaHeight;
  }

  @Override
  public String toString() {
    StringBuilder boardArea = new StringBuilder();

    for (int i = arenaHeight - 1; i >= 0; i--) {
      for (int j = 0; j < arenaWidth; j++) {
        boardArea.append(getMark(j, i));
      }
      boardArea.append("\n");
    }

    return boardArea.toString();
  }

  private String getMark(int x, int y) {
    return isCatHere(x, y) ? "V" : ".";
  }

  private boolean isCatHere(int x, int y) {
    return cat != null && cat.isHere(x, y);
  }

  public void positionCat(Dimension dimension, Position position, int speed) throws RuntimeException {
    if (isOutsideArena(dimension.width(), dimension.height(), position.x(), position.y())) {
      throw new RuntimeException("Cat placed out of bounds.");
    }
    cat = new Cat(dimension, position, speed);
  }

  boolean isOutsideArena(int width, int height, int x, int y) {
    return 0 > x || x + width > arenaWidth || 0 > y || y + height > arenaHeight;
  }

  public void moveCatRight() {
    if (cat.getRightCorner() + cat.getSpeed() < arenaWidth) {
      cat.moveRight();
    } else {
      cat.position(arenaWidth - cat.getWidth());
    }
  }

  public void moveCatLeft() {
    if (cat.getLeftCorner() - cat.getSpeed() >= 0) {
      cat.moveLeft();
    } else {
      cat.position(0);
    }
  }
}
