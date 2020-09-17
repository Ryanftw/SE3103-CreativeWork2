package view;

import java.awt.Font;
import javax.swing.JPanel;
import model.WhackAMole;
import model.WhackAMole.Pos;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WhackAMoleCanvas extends JPanel {

	public static int MOLESPEED = 1000;
	public static int WIDTH = 800;
	public static int LENGTH = 800;
	private int rand;
	private int previous = -1;
	private Pos current;
	private WhackAMole mole;
	private WhackAMolePanel panel;
	private Graphics2D g2;
	private Timer timer;
	private Timer moleTimer;
	private int points = 0;

	public WhackAMoleCanvas(WhackAMolePanel panel) {
		this.panel = panel;
		setPreferredSize(new Dimension(WIDTH, LENGTH));
		setBackground(Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;

		WhackAMolePanel.GameState state = panel.getGameState();
		if (state == WhackAMolePanel.GameState.READY) {
			g2.setColor(Color.red);
			g2.setFont(new Font("Arial", Font.BOLD, 36));
			g2.drawString("Select Difficulty and Press Play", 150, 350);
		} else {
			if (state == WhackAMolePanel.GameState.GAMEOVER) {
				g2.setColor(Color.red);
				g2.setFont(new Font("Arial", Font.BOLD, 36));
				g2.drawString("GAME OVER", 290, 410);
			}
			g2.setColor(Color.red);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					g2.drawOval(i * 140 + 170, j * 180 + 100, 46, 46);
				}
			}
			rand = (int) (Math.random() * 16);
			if (previous == rand) {
				rand = ((rand + 8) / 2);
			}

			current = mole.getPos(rand);
			g2.setColor(Color.red);
			g2.fillOval(current.x, current.y, 46, 46);

			if (panel.getListener().getPoints() > points
					&& panel.getListener().getPoints() < panel.getListener().getMaxPoints()) {
				moleTimer.restart();
				points++;
			}
		}
	}

	public void initGame() {
		moleTimer = new Timer(MOLESPEED, panel.getListener());
		moleTimer.setRepeats(true);
		moleTimer.start();
		mole = panel.getListener().getMole();
		timer = new Timer(1000, panel.getListener());
		timer.setRepeats(true);
		timer.start();
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				mole.setPos(k, i * 140 + 170, j * 180 + 100);
				k++;
			}
		}
	}

	public void setMOLESPEED(int x) {
		MOLESPEED = x;
	}

	public Timer getTimer() {
		return timer;
	}

	public WhackAMolePanel getPanel() {
		return panel;
	}

	public Timer getMoleTimer() {
		return moleTimer;
	}

	public Pos getCurrent() {
		return current;
	}
}
