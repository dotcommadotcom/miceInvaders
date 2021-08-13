package mice_invaders.gui;

import mice_invaders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static mice_invaders.gui.Commons.*;

public class GameGraphics {
  private Cat cat;
  private MiceInvader miceInvader;
  private int dx;
  private int dy;
  private int x = 40;
  private int y = 60;
  private int w;
  private int h;
  private Image catImage;

  public GameGraphics() {
    catImage = loadImage("src/main/resources/cat.png");

    miceInvader = new MiceInvader(WIDTH, HEIGHT);
    miceInvader.positionCat(new Size(catImage.getWidth(null), catImage.getHeight(null)),
            new Coordinate(INITIAL_X, INITIAL_Y), INITIAL_SPEED);
    cat = miceInvader.getCat();
  }

  private Image loadImage(String filename) {
    return scaleImage(new ImageIcon(filename).getImage());
  }

  private Image scaleImage(Image image) {
    return image.getScaledInstance(BOX_SIZE, -1, Image.SCALE_FAST);
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


  public void moveLeft() {
    miceInvader.moveCatLeft();
  }

  public void moveRight() {
    miceInvader.moveCatRight();
  }

  public void keyPressed(KeyEvent keyEvent) {
    if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
      moveLeft();
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
      moveRight();
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
