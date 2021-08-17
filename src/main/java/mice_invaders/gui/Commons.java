package mice_invaders.gui;

public interface Commons {
  String RESOURCES = "src/main/resources/";

  String CAT_MARK = "V";
  String MISSILE_MARK = "M";
  String EMPTY_MARK = ".";
  String MOUSE_MARK = "Y";

  int GAME_WIDTH = 600;
  int GAME_HEIGHT = 400;

  int GROUND = (int) (GAME_HEIGHT * 0.9);
  int BOX_SIZE = 20;
  int DELAY = 10;

  int CAT_START_X = (int) (GAME_WIDTH * 0.5);
  int CAT_START_Y = GROUND - BOX_SIZE;
  int CAT_SPEED = 20;

  int MOUSE_START_X = (int) (GAME_WIDTH * 0.5) + BOX_SIZE;
  int MOUSE_START_Y = BOX_SIZE;
  int MOUSE_SPEED = 1;

  int MISSILE_WIDTH = (int) (BOX_SIZE * 0.1);
  int MISSILE_HEIGHT = (int) (BOX_SIZE * 0.5);
  int MISSILE_SPEED = 5;



  int ALIEN_HEIGHT = 12;
  int ALIEN_WIDTH = 12;
  int ALIEN_INIT_X = 150;
  int ALIEN_INIT_Y = 5;

  int GO_DOWN = 15;
  int NUMBER_OF_ALIENS_TO_DESTROY = 24;
  int CHANCE = 5;
  int PLAYER_WIDTH = 15;
  int PLAYER_HEIGHT = 10;

}
