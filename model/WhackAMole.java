package model;

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

	public Pos[] getPosition() {
		return p;
	}

}