package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.WhackAMoleCanvas;

public class MoleTimerListener implements ActionListener {

	private WhackAMoleCanvas canvas;

	public MoleTimerListener(WhackAMoleCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		canvas.repaint();
	}

}