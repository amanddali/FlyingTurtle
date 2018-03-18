package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Turtle turtle2;
	ArrayList<Carrot> carrots;
	ArrayList<LuckyCharm> charms;
	long enemyTimer;
	long charmTimer;
	int enemySpawnTime;
	int charmSpawnTime;
	int score;

	ObjectManager(Turtle turtle2) {
		this.turtle2 = turtle2;
		carrots = new ArrayList<Carrot>();
		charms = new ArrayList<LuckyCharm>();
		enemyTimer = 0;
		charmTimer = 0;
		enemySpawnTime = 5000;
		charmSpawnTime = new Random().nextInt(4001) + 2000;
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
		if (System.currentTimeMillis() - charmTimer >= charmSpawnTime) {
			addCharm(new LuckyCharm(1000, new Random().nextInt(FlyingTurtle.HEIGHT - 100), 40, 40));
			charmTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (Carrot carrot : carrots) {
			if (turtle2.collisionBox.intersects(carrot.collisionBox)) {
				turtle2.isAlive = false;
			}
		}
		for (LuckyCharm charm : charms) {
			if (turtle2.collisionBox.intersects(charm.collisionBox)) {
				charm.isAlive = false;
			}
		}
	}

	public void collectCharms() {
		for (int i = 0; i < charms.size(); i++) {
			if (charms.get(i).isAlive == false) {
				charms.remove(i);
				score += 1;
			}
		}
	}

	public void reset() {
		carrots.clear();
		charms.clear();
	}
}
