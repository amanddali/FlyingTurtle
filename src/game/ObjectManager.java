package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Turtle turtle2;
	ArrayList<Carrot> carrots;
	ArrayList<LuckyCharm> charms;
	long enemyTimer;
	int enemySpawnTime;
	int charmSpawnTime;
	int score;

	ObjectManager(Turtle turtle2) {
		this.turtle2 = turtle2;
		carrots = new ArrayList<Carrot>();
		charms = new ArrayList<LuckyCharm>();
		enemyTimer = 0;
		enemySpawnTime = 5000;
		charmSpawnTime = new Random().nextInt(6001) + 2000;
		score = 0;
	}

	public void update() {
		turtle2.update();
		for (Carrot carrot : carrots) {
			carrot.update();
		}
		for (LuckyCharm charm : charms) {
			charm.update();
		}
	}

	public void draw(Graphics g) {
		turtle2.draw(g);
		for (Carrot carrot : carrots) {
			carrot.draw(g);
		}
		for (LuckyCharm charm : charms) {
			charm.draw(g);
		}
	}

	public void addCarrot(Carrot carrot) {
		carrots.add(carrot);
	}

	public void addTurtle(Turtle turtle) {
		this.turtle2 = turtle;
	}

	public void addCharm(LuckyCharm charm) {
		charms.add(charm);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addCarrot(new Carrot(new Random().nextInt(FlyingTurtle.WIDTH - 200), 0, 30, 80));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void manageCharms() {
		if (System.currentTimeMillis() - enemyTimer >= charmSpawnTime) {
			addCharm(new LuckyCharm(new Random().nextInt(1000), FlyingTurtle.HEIGHT, 25, 25));

		}
	}

	public void checkCollision() {
		for (Carrot carrot : carrots) {
			if (turtle2.collisionBox.intersects(carrot.collisionBox)) {
				turtle2.isAlive = false;
			}
		}
	}

	public void reset() {
		carrots.clear();
	}
}
