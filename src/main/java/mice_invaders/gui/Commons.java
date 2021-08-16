package mice_invaders.gui;

public interface Commons {
  String RESOURCES = "src/main/resources/";

  int GAME_WIDTH = 600;
  int GAME_HEIGHT = 400;

  int GROUND = (int) (GAME_HEIGHT * 0.8);
  int BOX_SIZE = 20; // use for cat, alien size
  int DELAY = 10;

  int CAT_START_X = (int) (GAME_WIDTH * 0.5);
  int CAT_START_Y = GROUND - BOX_SIZE;

  int MISSILE_WIDTH = (int) (BOX_SIZE * 0.1);
  int MISSILE_HEIGHT = (int) (BOX_SIZE * 0.5);
  int MISSILE_SPEED = 2;

  int INITIAL_SPEED = 10;

  int BORDER_RIGHT = 30;
  int BORDER_LEFT = 5;

  int ALIEN_HEIGHT = 12;
  int ALIEN_WIDTH = 12;
  int ALIEN_INIT_X = 150;
  int ALIEN_INIT_Y = 5;

  int GO_DOWN = 15;
  int NUMBER_OF_ALIENS_TO_DESTROY = 24;
  int CHANCE = 5;
//  int DELAY = 17;
  int PLAYER_WIDTH = 15;
  int PLAYER_HEIGHT = 10;

}
