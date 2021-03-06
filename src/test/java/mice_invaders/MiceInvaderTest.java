package mice_invaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static mice_invaders.Direction.LEFT;
import static mice_invaders.Direction.RIGHT;
import static org.junit.jupiter.api.Assertions.*;

public class MiceInvaderTest {

  MiceInvader miceInvader;

  @BeforeEach
  public void setUp() {
    miceInvader = new MiceInvader(15, 10);
  }

  @Test
  public void canaryTest() {
    assertTrue(true);
  }

  @Test
  public void createArenaAndConvertToString() {
    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            """, miceInvader.toString());
  }

  @Test
  public void placeCatInArena() {
    miceInvader.positionCat(new Size(), new Coordinate(7, 9), 1);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            .......V.......
            """, miceInvader.toString());
  }

  @Test
  public void placeCatOutsideArenaThrowException() {
    Exception exception = assertThrows(RuntimeException.class, () -> miceInvader.positionCat(new Size(), new Coordinate(15, 0), 1));

    assertTrue(exception.getMessage().contains("Cat placed out of bounds."));
  }

  @Test
  public void checkIsOutsideArenaReturnsTrueForDefaultSize() {
    assertAll(
      () -> assertTrue(miceInvader.isOutsideArena(1, 1, -1, 0)),
      () -> assertTrue(miceInvader.isOutsideArena(1, 1, 15, 0)),
      () -> assertTrue(miceInvader.isOutsideArena(1, 1, 0, -1)),
      () -> assertTrue(miceInvader.isOutsideArena(1, 1, 0, 10))
    );
  }

  @Test
  public void checkIsOutsideArenaReturnsFalseForDefaultSize() {
    assertAll(
      () -> assertFalse(miceInvader.isOutsideArena(1, 1, 0, 0)),
      () -> assertFalse(miceInvader.isOutsideArena(1, 1, 14, 0)),
      () -> assertFalse(miceInvader.isOutsideArena(1, 1, 0, 9))
    );
  }

  @Test
  public void placeCatWithSizeInArena() {
    miceInvader.positionCat(new Size(2), new Coordinate(7, 8), 1);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            .......VV......
            .......VV......
            """, miceInvader.toString());
  }

  @Test
  public void placeCatWithSizeOutsideArena() {
    Exception exception = assertThrows(RuntimeException.class, () -> miceInvader.positionCat(new Size(3, 2), new Coordinate(13, 8), 1));

    assertTrue(exception.getMessage().contains("Cat placed out of bounds."));
  }

  @Test
  public void checkIsOutsideArenaReturnsTrueForNonDefaultSize() {
    assertAll(
      () -> assertTrue(miceInvader.isOutsideArena(1, 2, 0, 9)),
      () -> assertTrue(miceInvader.isOutsideArena(2, 1, 14, 0))
    );
  }

  @Test
  public void checkIsOutsideArenaReturnsFalseForNonDefaultSize() {
    assertAll(
      () -> assertFalse(miceInvader.isOutsideArena(1, 2, 0, 8)),
      () -> assertFalse(miceInvader.isOutsideArena(2, 1, 13, 0))
    );
  }

  @Test
  public void moveCatRightOneStep() {
    miceInvader.positionCat(new Size(), new Coordinate(7, 9), 1);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), RIGHT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ........V......
            """, miceInvader.toString());
  }

  @Test
  public void moveCatRightButStayStill() {
    miceInvader.positionCat(new Size(), new Coordinate(14, 9), 1);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), RIGHT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ..............V
            """, miceInvader.toString());
  }

  @Test
  public void moveCatRightWithSizeButStayStill() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(12, 8), 1);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), RIGHT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ............VVV
            ............VVV
            """, miceInvader.toString());
  }

  @Test
  public void moveCatRightWithSpeed() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(8, 8), 3);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), RIGHT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...........VVV.
            ...........VVV.
            """, miceInvader.toString());
  }

  @Test
  public void moveCatRightWithSpeedButStayStill() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(12, 8), 3);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), RIGHT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ............VVV
            ............VVV
            """, miceInvader.toString());
  }

  @Test
  public void moveCatPartialRightWithSpeed() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(11, 8), 3);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), RIGHT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ............VVV
            ............VVV
            """, miceInvader.toString());
  }

  @Test
  public void moveCatLeftWithSizeOneStep() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(2, 8), 1);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), LEFT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            .VVV...........
            .VVV...........
            """, miceInvader.toString());
  }

  @Test
  public void moveCatLeftWithSizeButStayStill() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(0, 8), 1);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), LEFT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            VVV............
            VVV............
            """, miceInvader.toString());
  }

  @Test
  public void moveCatLeftWithSpeed() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(4, 8), 3);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), LEFT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            .VVV...........
            .VVV...........
            """, miceInvader.toString());
  }

  @Test
  public void moveCatLeftWithSpeedButStayStill() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(0, 8), 3);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), LEFT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            VVV............
            VVV............
            """, miceInvader.toString());
  }

  @Test
  public void moveCatPartialLeftWithSpeed() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(1, 8), 3);

    miceInvader.moveSpriteInDirection(miceInvader.getCat(), LEFT);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            VVV............
            VVV............
            """, miceInvader.toString());
  }

  @Test
  public void shootMissileWithDefaultSizeFromMiddleOfCat() {
    miceInvader.positionCat(new Size(4, 2), new Coordinate(6, 8), 1);

    miceInvader.shootMissile(new Size(), 4);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            .......M.......
            ......VVVV.....
            ......VVVV.....
            """, miceInvader.toString());
  }

  @Test
  public void shootMissileWithNonDefaultSizeFromMiddleOfCat() {
    miceInvader.positionCat(new Size(6, 2), new Coordinate(4, 8), 1);

    miceInvader.shootMissile(new Size(5, 5), 4);

    assertEquals("""
            ...............
            ...............
            ...............
            ....MMMMM......
            ....MMMMM......
            ....MMMMM......
            ....MMMMM......
            ....MMMMM......
            ....VVVVVV.....
            ....VVVVVV.....
            """, miceInvader.toString());
  }

  @Test
  public void missileWiderThanCatThrowsException() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(6, 8), 1);

    Exception exception = assertThrows(RuntimeException.class, () -> miceInvader.shootMissile(new Size(4, 1), 4));

    assertTrue(exception.getMessage().contains("Missile is wider than cat."));
  }

  @Test
  public void missileHigherThanArenaThrowsException() {
    miceInvader.positionCat(new Size(3, 2), new Coordinate(6, 8), 1);

    Exception exception = assertThrows(RuntimeException.class, () -> miceInvader.shootMissile(new Size(1, 9), 4));

    assertTrue(exception.getMessage().contains("Missile is too high for arena."));
  }

  @Test
  public void moveMissileUp() {
    miceInvader.positionCat(new Size(7, 2), new Coordinate(5, 8), 2);
    miceInvader.shootMissile(new Size(3, 2), 1);

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            .......MMM.....
            .......MMM.....
            ...............
            .....VVVVVVV...
            .....VVVVVVV...
            """, miceInvader.toString());
  }

  @Test
  public void moveMissileOutOfArena() {
    miceInvader.positionCat(new Size(7, 2), new Coordinate(5, 8), 2);
    miceInvader.shootMissile(new Size(3, 2), 4);

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            .....VVVVVVV...
            .....VVVVVVV...
            """, miceInvader.toString());
  }

  @Test
  public void moveMissileWithHigherSpeed() {
    miceInvader.positionCat(new Size(7, 2), new Coordinate(5, 8), 2);
    miceInvader.shootMissile(new Size(3, 2), 4);

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertEquals("""
            ...............
            ...............
            .......MMM.....
            .......MMM.....
            ...............
            ...............
            ...............
            ...............
            .....VVVVVVV...
            .....VVVVVVV...
            """, miceInvader.toString());
  }

  @Test
  public void placeMouseWithCoordinateAndSizeInArena() {
    miceInvader.positionMouse(new Size(2,2), new Coordinate(5, 0), 2);

    assertEquals("""
            .....YY........
            .....YY........
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            """, miceInvader.toString());
  }

  @Test
  public void placeMouseWithSizeOutsideArena() {
    Exception exception = assertThrows(RuntimeException.class, () -> miceInvader.positionMouse(new Size(3, 2), new Coordinate(13, 0), 1));

    assertTrue(exception.getMessage().contains("Mouse placed out of bounds."));
  }

  @Test
  public void moveMouseRightFirstWithSpeed() {
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(8, 0), 3);

    miceInvader.moveMouse();

    assertEquals("""
            ...........YYY.
            ...........YYY.
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            """, miceInvader.toString());
  }

  @Test
  public void moveMousePartialRightWithSpeedButStayStill() {
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(10, 0), 3);

    miceInvader.moveMouse();

    assertEquals("""
            ............YYY
            ............YYY
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            """, miceInvader.toString());
  }

  @Test
  public void mouseHitsBorderReturnsTrue() {
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(10, 0), 3);

    miceInvader.moveMouse();

    assertTrue(miceInvader.getMouse().isBorderHit());
  }

  @Test
  public void mouseLeavesBorderReturnsFalse() {
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(10, 0), 3);
    miceInvader.moveMouse();

    miceInvader.moveMouse();

    assertFalse(miceInvader.getMouse().isBorderHit());
  }

  @Test
  public void moveMouseDownToNextLineDefinedByHeight() {
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(10, 0), 3);
    miceInvader.moveMouse();

    miceInvader.moveMouse();

    assertEquals("""
            ...............
            ...............
            ............YYY
            ............YYY
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            """, miceInvader.toString());
  }

  @Test
  public void moveMouseLeftAfterLeavingRightBorder() {
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(10, 0), 3);
    for (int i = 0; i < 2; i++) {
      miceInvader.moveMouse();
    }

    miceInvader.moveMouse();

    assertEquals("""
            ...............
            ...............
            .........YYY...
            .........YYY...
            ...............
            ...............
            ...............
            ...............
            ...............
            ...............
            """, miceInvader.toString());
  }

  @Test
  public void moveMouseRightAfterLeavingLeftBorder() {
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(10, 0), 3);
    for (int i = 0; i < 8; i++) {
      miceInvader.moveMouse();
    }

    miceInvader.moveMouse();

    assertEquals("""
            ...............
            ...............
            ...............
            ...............
            ...YYY.........
            ...YYY.........
            ...............
            ...............
            ...............
            ...............
            """, miceInvader.toString());
  }

  @Test
  public void detectCollisionWhenSpritesMeetAtBottomLeftCorner() {
    miceInvader.positionCat(new Size(), new Coordinate(7, 8), 3);
    miceInvader.positionMouse(new Size(3), new Coordinate(8, 0), 3);
    miceInvader.shootMissile(new Size(), 1);
    for (int i = 0; i < 3; i++) {
      miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    }

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertAll(
            () -> assertEquals("""
                    ........YYY....
                    ........YYY....
                    ........YYY....
                    .......M.......
                    ...............
                    ...............
                    ...............
                    ...............
                    .......V.......
                    ...............
                    """, miceInvader.toString()),
            () -> assertTrue(miceInvader.detectCollision(miceInvader.getMissile(), miceInvader.getMouse()))
    );
  }

  @Test
  public void detectNoCollisionWhenSpritesDoNotMeetOnLeft() {
    miceInvader.positionCat(new Size(), new Coordinate(8, 8), 3);
    miceInvader.positionMouse(new Size(3), new Coordinate(8, 0), 3);
    miceInvader.shootMissile(new Size(), 1);
    for (int i = 0; i < 2; i++) {
      miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    }

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertAll(
            () -> assertEquals("""
                    ........YYY....
                    ........YYY....
                    ........YYY....
                    ...............
                    ........M......
                    ...............
                    ...............
                    ...............
                    ........V......
                    ...............
                    """, miceInvader.toString()),
            () -> assertFalse(miceInvader.detectCollision(miceInvader.getMissile(), miceInvader.getMouse()))
    );
  }

  @Test
  public void detectNoCollisionWhenSpritesDoNotMeetOnRight() {
    miceInvader.positionCat(new Size(), new Coordinate(12, 8), 3);
    miceInvader.positionMouse(new Size(3), new Coordinate(8, 0), 3);
    miceInvader.shootMissile(new Size(), 1);
    for (int i = 0; i < 3; i++) {
      miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    }

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertAll(
            () -> assertEquals("""
                    ........YYY....
                    ........YYY....
                    ........YYY....
                    ............M..
                    ...............
                    ...............
                    ...............
                    ...............
                    ............V..
                    ...............
                    """, miceInvader.toString()),
            () -> assertFalse(miceInvader.detectCollision(miceInvader.getMissile(), miceInvader.getMouse()))
    );
  }

  @Test
  public void detectNoCollisionWhenSpritesDoNotMeetOnTop() {
    miceInvader.positionCat(new Size(), new Coordinate(9, 8), 3);
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(8, 2), 3);
    miceInvader.shootMissile(new Size(), 1);
    for (int i = 0; i < 6; i++) {
      miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    }

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertAll(
            () -> assertEquals("""
                    .........M.....
                    ...............
                    ........YYY....
                    ........YYY....
                    ...............
                    ...............
                    ...............
                    ...............
                    .........V.....
                    ...............
                    """, miceInvader.toString()),
            () -> assertFalse(miceInvader.detectCollision(miceInvader.getMissile(), miceInvader.getMouse()))
    );
  }

  @Test
  public void detectCollisionWhenSpritesMeetAtTopRight() {
    miceInvader.positionCat(new Size(), new Coordinate(11, 8), 3);
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(8, 2), 3);
    miceInvader.shootMissile(new Size(), 1);
    for (int i = 0; i < 5; i++) {
      miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    }

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertAll(
            () -> assertEquals("""
                    ...............
                    ...........M...
                    ........YYY....
                    ........YYY....
                    ...............
                    ...............
                    ...............
                    ...............
                    ...........V...
                    ...............
                    """, miceInvader.toString()),
            () -> assertTrue(miceInvader.detectCollision(miceInvader.getMissile(), miceInvader.getMouse()))
    );
  }

  @Test
  public void detectCollisionWhenSpritesMeetAtTopLeft() {
    miceInvader.positionCat(new Size(), new Coordinate(6, 8), 3);
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(8, 2), 3);
    miceInvader.shootMissile(new Size(), 1);
    for (int i = 0; i < 5; i++) {
      miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    }

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertAll(
            () -> assertEquals("""
                    ...............
                    .......M.......
                    ........YYY....
                    ........YYY....
                    ...............
                    ...............
                    ...............
                    ...............
                    .......V.......
                    ...............
                    """, miceInvader.toString()),
            () -> assertTrue(miceInvader.detectCollision(miceInvader.getMissile(), miceInvader.getMouse()))
    );
  }

  @Test
  public void detectCollisionWhenSpritesMeetAtBottomRight() {
    miceInvader.positionCat(new Size(), new Coordinate(11, 8), 3);
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(8, 2), 3);
    miceInvader.shootMissile(new Size(), 1);
    for (int i = 0; i < 2; i++) {
      miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    }

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertAll(
            () -> assertEquals("""
                    ...............
                    ...............
                    ........YYY....
                    ........YYY....
                    ...........M...
                    ...............
                    ...............
                    ...............
                    ...........V...
                    ...............
                    """, miceInvader.toString()),
            () -> assertTrue(miceInvader.detectCollision(miceInvader.getMissile(), miceInvader.getMouse()))
    );
  }

  @Test
  public void detectCollisionWhenPartialOverlap() {
    miceInvader.positionCat(new Size(3, 1), new Coordinate(7, 8), 3);
    miceInvader.positionMouse(new Size(3, 2), new Coordinate(8, 2), 3);
    miceInvader.shootMissile(new Size(2, 1), 1);
    for (int i = 0; i < 2; i++) {
      miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);
    }

    miceInvader.moveSpriteInDirection(miceInvader.getMissile(), Direction.UP);

    assertAll(
            () -> assertEquals("""
                    ...............
                    ...............
                    ........YYY....
                    ........YYY....                   
                    .......MM......
                    ...............
                    ...............
                    ...............
                    .......VVV.....
                    ...............
                    """, miceInvader.toString()),
            () -> assertTrue(miceInvader.detectCollision(miceInvader.getMissile(), miceInvader.getMouse()))
    );
  }
}
