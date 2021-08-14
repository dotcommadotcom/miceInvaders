package mice_invaders.gui;

import mice_invaders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static mice_invaders.gui.Commons.*;

public class GameGraphics {
  private Cat cat;
  private MiceInvader miceInvader;
  private Image catImage;
  private int dy;
  private int y;


  public GameGraphics() {
    catImage = loadImage("src/main/resources/cat.png");

    miceInvader = new MiceInvader(WIDTH, HEIGHT);
    miceInvader.positionCat(new Size(BOX_SIZE, BOX_SIZE), new Coordinate(INITIAL_X, INITIAL_Y), 10);
    cat = miceInvader.getCat();
  }

  private Image loadImage(String filename) {
    return scaleImage(new ImageIcon(filename).getImage());
  }

  private Image scaleImage(Image image) {
    return image.getScaledInstance(BOX_SIZE, BOX_SIZE, Image.SCALE_FAST);
  }

  public Image getCatImage() {
    return catImage;
  }

  public int getX() {
    return cat.getLeft();
  }

  public int getY() {
    return cat.getTop();
  }

  public void keyPressed(KeyEvent keyEvent) {
    if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
      miceInvader.moveCatLeft();
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
      miceInvader.moveCatRight();
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
    }
  }

  public void keyReleased(KeyEvent keyEvent) {
    if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
    }
  }

}
