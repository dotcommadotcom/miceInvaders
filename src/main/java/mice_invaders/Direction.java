package mice_invaders;

public enum Direction {
  UP(-1),
  DOWN(1),
  LEFT(-1),
  RIGHT(1);

  private int value;

  Direction(int _value) {
    value = _value;
  }

  public int getValue() {
    return value;
  }

}
