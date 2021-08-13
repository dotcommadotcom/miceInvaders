package mice_invaders.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static mice_invaders.gui.Commons.*;

public class GamePanel extends JPanel implements ActionListener {

  private Timer timer;
  private GameGraphics gameGraphics;

  public GamePanel() {
    initializeBoard();
    gameGraphics = new GameGraphics();
    startTimer();
  }

  private void initializeBoard() {
    addKeyListener(new KeyInput());
    setBackground(Color.black);
    setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
    setFocusable(true);
  }

  private void startTimer() {
    timer = new Timer(DELAY, this);
    timer.start();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    draw(graphics);

    Toolkit.getDefaultToolkit().sync();
  }

  private void draw(Graphics graphics) {
    Graphics2D graphics2D = (Graphics2D) graphics;

    graphics2D.drawImage(gameGraphics.getCatImage(), gameGraphics.getX(), gameGraphics.getY(), this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    move();
  }

  private void move() {
    repaint();
  }

  private class KeyInput extends KeyAdapter {
    @Override
    public void keyReleased(KeyEvent event) {
      gameGraphics.keyReleased(event);
    }

    @Override
    public void keyPressed(KeyEvent event) {
      gameGraphics.keyPressed(event);
    }
  }
}