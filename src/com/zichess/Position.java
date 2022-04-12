package com.zichess;

public class Position {

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x, y;

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return other.x == this.x && other.y == this.y;
	}
}
