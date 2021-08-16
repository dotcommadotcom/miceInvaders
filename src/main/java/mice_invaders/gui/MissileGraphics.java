package mice_invaders.gui;

import mice_invaders.Size;

import static mice_invaders.gui.Commons.*;

public class MissileGraphics extends SpriteGraphics {

  public MissileGraphics() {
    setVisible(false);
  }

  @Override
  public void initializeImage() {
    loadImage(RESOURCES + "square.png");
  }

  @Override
  public Size getSpriteSize() {
    return new Size(MISSILE_WIDTH, MISSILE_HEIGHT);
  }
}
