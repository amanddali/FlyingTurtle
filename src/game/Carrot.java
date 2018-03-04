package game;

import java.awt.Graphics;

public class Carrot extends GameObject {

	Carrot(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void update() {
		super.update();
		y += 1;
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.carrotImg, x, y, width, height, null);
	}
}
