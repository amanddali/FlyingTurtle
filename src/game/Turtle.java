package game;
import java.awt.Graphics;

public class Turtle extends GameObject {
	int speed;

	Turtle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	public void update() {
		super.update();
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.turtleImg, x, y, width, height, null);
	}
}
