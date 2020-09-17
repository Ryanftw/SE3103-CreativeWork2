package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.WhackAMoleCanvas;

public class TimerListener implements ActionListener {

	private int count = 60;
	private WhackAMoleCanvas canvas;

	public TimerListener(WhackAMoleCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count--;
		canvas.getPanel().getTimeLabel().setText("Time : " + Integer.toString(count));
	}

}
