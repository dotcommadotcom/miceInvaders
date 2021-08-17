package mice_invaders.gui;

import mice_invaders.Size;

import static mice_invaders.gui.Commons.*;

public class CatGraphics extends SpriteGraphics {

  @Override
  public void initializeImage() {
    loadImage(RESOURCES + "cat.png");
  }

  @Override
  public Size getSpriteSize() {
    return new Size(BOX_SIZE);
  }
}




