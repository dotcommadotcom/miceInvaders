package mice_invaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//public class GameGUI extends JPanel {
//  public static final int WIDTH = 1000;
//  public static final int HEIGHT = 800;
//
//  int x = 0;
//  int y = 0;
//  int xa = 1;
//  int ya = 1;
//
////  public GameGUI() {
////    addKeyListener(new KeyListener() {
////      @Override
////      public void keyTyped(KeyEvent e) {
////
////      }
////
////      @Override
////      public void keyPressed(KeyEvent e) {
////
////      }
////
////      @Override
////      public void keyReleased(KeyEvent e) {
////
////      }
////    });
////  }
//
//  private void moveBall() {
//    if (x + xa < 0)
//      xa = 1;
//    if (x + xa > getWidth() - 30)
//      xa = -1;
//    if (y + ya < 0)
//      ya = 1;
//    if (y + ya > getHeight() - 30)
//      ya = -1;
//
//    x = x + xa;
//    y = y + ya;
//  }
//
//  @Override
//  public void paint(Graphics graphics) {
//    super.paint(graphics);
//    Graphics2D graphics2D = (Graphics2D) graphics;
//    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//    graphics2D.fillRect(x, y, 30, 30);
//  }
//
//  public GameGUI() {
//    JFrame arena = new JFrame("Mice Invaders");
//    MiceInvader miceInvader = new MiceInvader(WIDTH, HEIGHT);
//    //arena.add(miceInvader);
//    arena.setSize(WIDTH, HEIGHT);
//
//  }
//
//  public static void main(String[] args) throws InterruptedException {
//    JFrame arena = new JFrame("Mice Invaders");
//    GameGUI game = new GameGUI();
//    arena.add(game);
//    arena.setSize(WIDTH, HEIGHT);
//    arena.setVisible(true);
//    arena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    while (true) {
//      game.moveBall();
//      game.repaint();
//      Thread.sleep(10);
//    }
//  }
//}
