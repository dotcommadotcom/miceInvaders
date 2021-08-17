package mice_invaders.gui;

import mice_invaders.Coordinate;
import mice_invaders.MiceInvader;
import mice_invaders.Size;
import mice_invaders.Sprite;

import javax.swing.*;
import java.awt.Image;

import static mice_invaders.gui.Commons.*;

public abstract class SpriteGraphics {

  private boolean visible;
  private Image image;
  private boolean dying;

  public SpriteGraphics() {
    setVisible(true);
    initializeImage();
  }

  public void die() {
    setVisible(false);
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public boolean isVisible() {
    return visible;
  }

  public abstract Size getSpriteSize();

  public abstract void initializeImage();

  protected void loadImage(String filename) {
    this.image = scaleImage(new ImageIcon(filename).getImage(), getSpriteSize());
  }

  private Image scaleImage(Image image, Size size) {
    return image.getScaledInstance(size.width(), size.height(), Image.SCALE_FAST);
  }

  public Image getImage() {
    return image;
  }

  public boolean isDying() {
    return this.dying;
  }
}
