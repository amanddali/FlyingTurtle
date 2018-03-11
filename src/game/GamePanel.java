package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
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
	Turtle turtle;
	boolean moveUp;
	boolean moveDown;
	ObjectManager om;
	public static BufferedImage turtleImg;
	public static BufferedImage carrotImg;
	public static BufferedImage charm1Img;
	public static BufferedImage charm2Img;
	public static BufferedImage charm3Img;
	public static BufferedImage charm4Img;
	public static BufferedImage charm5Img;
	public static BufferedImage charm6Img;
	public static BufferedImage charm7Img;
	public static BufferedImage charm8Img;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Oswald", Font.BOLD, 48);
		smallerFont = new Font("Oswald", Font.PLAIN, 30);
		turtle = new Turtle(150, 225, 50, 50);
		moveUp = false;
		moveDown = false;
		om = new ObjectManager(turtle);
		try {
			turtleImg = ImageIO.read(this.getClass().getResourceAsStream("turtle.png"));
			carrotImg = ImageIO.read(this.getClass().getResourceAsStream("carrot.png"));
			charm1Img = ImageIO.read(this.getClass().getResourceAsStream("charm1"));
			charm2Img = ImageIO.read(this.getClass().getResourceAsStream("charm2"));
			charm3Img = ImageIO.read(this.getClass().getResourceAsStream("charm3"));
			charm4Img = ImageIO.read(this.getClass().getResourceAsStream("charm4"));
			charm5Img = ImageIO.read(this.getClass().getResourceAsStream("charm5"));
			charm6Img = ImageIO.read(this.getClass().getResourceAsStream("charm6"));
			charm7Img = ImageIO.read(this.getClass().getResourceAsStream("charm7"));
			charm8Img = ImageIO.read(this.getClass().getResourceAsStream("charm8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moveUp = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveDown = true;
		}
		turtle.update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
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
		if (moveUp == true && turtle.y > 10) {
			turtle.y -= turtle.speed;
		}
		if (moveDown == true && turtle.y < 440) {
			turtle.y += turtle.speed;
		}
		om.update();
		om.manageEnemies();
		om.checkCollision();
		if (turtle.isAlive == false) {
			currentState = END_STATE;
			turtle = new Turtle(10, 400, 50, 50);
			om.reset();
			om.addTurtle(turtle);
		}
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
		om.draw(g);
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
