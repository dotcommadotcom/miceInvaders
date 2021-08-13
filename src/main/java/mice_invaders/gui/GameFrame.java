package mice_invaders.gui;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
  public GameFrame() {
    initializeGUI();
  }

  private void initializeGUI() {
    add(new GamePanel());

    pack();
    setTitle("Moving sprite");
    setLocationRelativeTo(null);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      GameFrame game = new GameFrame();
      game.setVisible(true);
    });
  }
}
