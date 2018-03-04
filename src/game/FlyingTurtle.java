package game;
import java.awt.Dimension;

import javax.swing.JFrame;

public class FlyingTurtle {
	JFrame frame;
	static final int WIDTH = 1000;
	static final int HEIGHT = 500;
	GamePanel gp;

	FlyingTurtle(int WIDTH, int HEIGHT) {
		frame = new JFrame();
		gp = new GamePanel();
	}

	public static void main(String[] args) {
		FlyingTurtle ft = new FlyingTurtle(WIDTH, HEIGHT);
		ft.setup();
	}

	public void setup() {
		frame.add(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gp.startGame();
		frame.addKeyListener(gp);
	}
}
