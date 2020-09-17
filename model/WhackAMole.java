package model;

import javax.swing.Timer;

import controller.MoleActionListener;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.Color;

public class WhackAMole {

	private Pos[] p = new Pos[16];

	public class Pos {
		public int x;
		public int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void setPos(int index, int x, int y) {
		p[index] = new Pos(x, y);
	}

	public Pos getPos(int index) {
		return p[index];
	}

}