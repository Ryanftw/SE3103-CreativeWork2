package controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.WhackAMole;
import view.WhackAMolePanel;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class MoleActionListener implements ActionListener, MouseListener {

	private WhackAMolePanel panel;
	private WhackAMole mole;

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
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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

}
