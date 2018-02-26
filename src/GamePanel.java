import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font smallerFont;
	boolean moveRight;
	boolean moveLeft;
	boolean moveUp;
	boolean moveDown;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Oswald", Font.BOLD, 48);
		smallerFont = new Font("Oswald", Font.PLAIN, 30);
		moveRight = false;
		moveLeft = false;
		moveUp = false;
		moveDown = false;
	}

	public void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState += 1;
			if (currentState == END_STATE) {

			}
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moveUp = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveDown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moveUp = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveDown = false;
		}
	}

	public void updateMenuState() {

	}

	public void updateGameState() {

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, FlyingTurtle.WIDTH, FlyingTurtle.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("FLYING TURTLE", 300, 100);
		g.setFont(smallerFont);
		g.drawString("press ENTER to start", 350, 250);
		g.drawString("press SPACE for instructions", 295, 400);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FlyingTurtle.WIDTH, FlyingTurtle.HEIGHT);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, FlyingTurtle.WIDTH, FlyingTurtle.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 350, 100);
		g.setFont(smallerFont);
		g.drawString("you collected 0 lucky charms", 300, 250);
		g.drawString("press ENTER to restart", 340, 400);
	}
}
