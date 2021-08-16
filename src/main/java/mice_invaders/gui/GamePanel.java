package mice_invaders.gui;

import mice_invaders.Coordinate;
import mice_invaders.MiceInvader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static mice_invaders.gui.Commons.*;

public class GamePanel extends JPanel implements ActionListener {
  private MiceInvader miceInvader;
  private CatGraphics catGraphics;
  private MissileGraphics missileGraphics;

  private boolean inGame = true;
  private String message = "Game Over";
  private Timer timer;

  public GamePanel(MiceInvader _miceInvader) {
    miceInvader = _miceInvader;

    initializePanel();
    initializeGame();
    startTimer();
  }//

  private void initializePanel() {
    addKeyListener(new keyInput());
    setFocusable(true);
    setBackground(Color.black);
    setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
  }//

  private void startTimer() {
    timer = new Timer(DELAY, this);
    timer.start();
  }//

  private void stopTimer() {
    if (timer.isRunning()) {
      timer.stop();
    }
  }//

  private void initializeGame() {
    catGraphics = new CatGraphics();
    missileGraphics = new MissileGraphics();
    miceInvader.positionCat(catGraphics.getSpriteSize(), new Coordinate(CAT_START_X, CAT_START_Y), INITIAL_SPEED);
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    draw(graphics);
  }//

  private void draw(Graphics graphics) {
    drawBackground(graphics);

    if (inGame) {
      drawGreenLine(graphics);
      drawCat(graphics);
      drawMissile(graphics);
    } else {
      stopTimer();
      drawGameOver(graphics);
    }

    Toolkit.getDefaultToolkit().sync();
  }//

  private void drawCat(Graphics graphics) {
    if (catGraphics.isVisible()) {
      graphics.drawImage(catGraphics.getImage(), miceInvader.getCat().getLeft(), miceInvader.getCat().getTop(), this);
    }

    if (catGraphics.isDying()) {
      catGraphics.die();
      inGame = false;
    }
  }//

  private void drawMissile(Graphics graphics) {
    if (missileGraphics.isVisible()) {
      graphics.drawImage(missileGraphics.getImage(),
              miceInvader.getMissile().getLeft(), miceInvader.getMissile().getTop(), this);
    }
  }

  private void drawGreenLine(Graphics graphics) {
    graphics.setColor(Color.green);
    graphics.drawLine(0, GROUND, GAME_WIDTH, GROUND);
  }//

  private void drawGameOver(Graphics graphics) {
    drawBackground(graphics);

    drawMessage(graphics);
  }//

  private void drawMessage(Graphics graphics) {
    var small = new Font("Helvetica", Font.BOLD, 14);
    var fontMetrics = this.getFontMetrics(small);

    graphics.setColor(Color.white);
    graphics.setFont(small);
    graphics.drawString(message, (GAME_WIDTH - fontMetrics.stringWidth(message)) / 2, GAME_WIDTH / 2);
  }//

  private void drawBackground(Graphics graphics) {
    graphics.setColor(Color.black);
    graphics.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
  }//

  private void update() {
    if (missileGraphics.isVisible()) {
      miceInvader.moveMissileUp();
    }

    if (miceInvader.getMissile() != null && miceInvader.getMissile().getBottom() < 0) {
      missileGraphics.setVisible(false);
    }
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    update();
    repaint();
  }//

  private class keyInput extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
      if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
        miceInvader.moveCatLeft();
      }

      if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
        miceInvader.moveCatRight();
      }

      if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
        if (!missileGraphics.isVisible()) {
          miceInvader.shootMissile(missileGraphics.getSpriteSize(), MISSILE_SPEED);
          missileGraphics.setVisible(true);
        }
      }

    }
  }//
}
