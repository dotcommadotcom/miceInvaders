package mice_invaders.gui;

import mice_invaders.MiceInvader;

import java.awt.EventQueue;
import javax.swing.*;

import static mice_invaders.gui.Commons.GAME_HEIGHT;
import static mice_invaders.gui.Commons.GAME_WIDTH;

public class GameFrame extends JFrame {

  public GameFrame(JPanel panel) {
    add(panel);
    initializeFrame();
  }

  private void initializeFrame() {
    setResizable(false);
    pack();

    setTitle("Mice Invaders");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    MiceInvader miceInvader = new MiceInvader(GAME_WIDTH, GAME_HEIGHT);
    GamePanel gamePanel = new GamePanel(miceInvader);

    EventQueue.invokeLater(() -> {

      GameFrame game = new GameFrame(gamePanel);
      game.setVisible(true);
    });
  }
}
