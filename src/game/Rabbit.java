package game;

import java.awt.Graphics;

public class Rabbit extends GameObject {

	Rabbit(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void update() {
		super.update();
		x -= 3;
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.rabbitImg, x, y, width, height, null);
	}

}
