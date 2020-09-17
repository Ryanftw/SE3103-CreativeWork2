package controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import model.WhackAMole;
import model.WhackAMole.Pos;
import view.WhackAMolePanel;
import view.WhackAMolePanel.GameState;

import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class MoleActionListener implements ActionListener, MouseListener {

	private int points = 0;
	private int maxPoints = 25;
	private WhackAMolePanel panel;
	private WhackAMole mole;
	private Pos pos;
	private int count = 30;

	public MoleActionListener(WhackAMolePanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == panel.getNewGameButton()) {
			mole = new WhackAMole();
			panel.getCanvas().initGame();
			panel.setGameState(WhackAMolePanel.GameState.PLAYING);
			panel.getNewGameButton().setEnabled(false);
			panel.getLevel1().setEnabled(false);
			panel.getLevel2().setEnabled(false);
			panel.getLevel3().setEnabled(false);
			panel.getLevel4().setEnabled(false);
			panel.getCanvas().repaint();
		} else if (source == panel.getExitButton()) {
			JFrame window = panel.getWindow();
			window.getContentPane().removeAll();
			var startScreen = new WhackAMolePanel(window);
			window.pack();
			window.revalidate();
		} else if (source == panel.getLevel1()) {
			panel.getCanvas().setMOLESPEED(1200);
			maxPoints = 10;
			count = 75;
			panel.getTimeLabel().setText("Time : " + Integer.toString(count));
		} else if (source == panel.getLevel2()) {
			panel.getCanvas().setMOLESPEED(900);
			maxPoints = 15;
			count = 50;
			panel.getTimeLabel().setText("Time : " + Integer.toString(count));
		} else if (source == panel.getLevel3()) {
			panel.getCanvas().setMOLESPEED(600);
			maxPoints = 20;
			count = 40;
			panel.getTimeLabel().setText("Time : " + Integer.toString(count));
		} else if (source == panel.getLevel4()) {
			panel.getCanvas().setMOLESPEED(300);
			maxPoints = 25;
			count = 30;
			panel.getTimeLabel().setText("Time : " + Integer.toString(count));
		} else if (source == panel.getCanvas().getTimer()) {
			count--;
			panel.getTimeLabel().setText("Time : " + Integer.toString(count));
			if (count == 0) {
				panel.getCanvas().getTimer().stop();
				panel.getCanvas().getMoleTimer().stop();
				panel.setGameState(GameState.GAMEOVER);
				panel.getCanvas().repaint();
			}
		} else if (source == panel.getCanvas().getMoleTimer()) {
			panel.getCanvas().repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		pos = panel.getCanvas().getCurrent();
		if (e.getX() >= pos.x && e.getX() <= (pos.x + 46) && e.getY() >= pos.y && e.getY() <= (pos.y + 46)) {
			if (panel.getGameState() != WhackAMolePanel.GameState.GAMEOVER) {
				++points;
				panel.getPoints().setText("Points : " + points);
				panel.getCanvas().repaint();

				if (points == maxPoints) {
					panel.setGameState(GameState.GAMEOVER);
					panel.getCanvas().getTimer().stop();
					panel.getCanvas().getMoleTimer().stop();
					panel.getCanvas().repaint();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public WhackAMole getMole() {
		return mole;
	}

	public int getPoints() {
		return points;
	}

	public int getMaxPoints() {
		return maxPoints;
	}

}
