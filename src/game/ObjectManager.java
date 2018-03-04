package game;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Turtle turtle2;
	ArrayList<Carrot> carrots;
	long enemyTimer;
	int enemySpawnTime;
	int score;

	ObjectManager(Turtle turtle2) {
		this.turtle2 = turtle2;
		carrots = new ArrayList<Carrot>();
		enemyTimer = 0;
		enemySpawnTime = 5000;
		score = 0;
	}

	public void update() {
		turtle2.update();
		for (Carrot carrot : carrots) {
			carrot.update();
		}
	}

	public void draw(Graphics g) {
		turtle2.draw(g);
		for (Carrot carrot : carrots) {
			carrot.draw(g);
		}
	}

	public void addCarrot(Carrot carrot) {
		carrots.add(carrot);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addCarrot(new Carrot(new Random().nextInt(FlyingTurtle.WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (Carrot carrot : carrots) {
			if (turtle2.collisionBox.intersects(carrot.collisionBox)) {
				turtle2.isAlive = false;
			}
		}
	}
}
