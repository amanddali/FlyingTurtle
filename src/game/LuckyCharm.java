package game;

import java.awt.Graphics;

public class LuckyCharm extends GameObject {

	LuckyCharm(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void update() {
		super.update();
		x -= 1;
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.charm1Img, x, y, width, height, null);
	}
}
