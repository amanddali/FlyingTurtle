package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class LuckyCharm extends GameObject {
	int charmType;
	BufferedImage charmImg;

	LuckyCharm(int x, int y, int width, int height) {
		super(x, y, width, height);
		charmType = new Random().nextInt(8) + 1;
		try {
			switch (charmType) {
			case 1:
				charmImg = ImageIO.read(this.getClass().getResourceAsStream("charm1.png"));
				break;
			case 2:
				charmImg = ImageIO.read(this.getClass().getResourceAsStream("charm2.png"));
				break;
			case 3:
				charmImg = ImageIO.read(this.getClass().getResourceAsStream("charm3.png"));
				break;
			case 4:
				charmImg = ImageIO.read(this.getClass().getResourceAsStream("charm4.png"));
				break;
			case 5:
				charmImg = ImageIO.read(this.getClass().getResourceAsStream("charm5.png"));
				break;
			case 6:
				charmImg = ImageIO.read(this.getClass().getResourceAsStream("charm6.png"));
				break;
			case 7:
				charmImg = ImageIO.read(this.getClass().getResourceAsStream("charm7.png"));
				break;
			case 8:
				charmImg = ImageIO.read(this.getClass().getResourceAsStream("charm8.png"));
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		super.update();
		x -= 3;
	}

	public void draw(Graphics g) {
		g.drawImage(charmImg, x, y, width, height, null);
	}
}
