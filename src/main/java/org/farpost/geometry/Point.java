package org.farpost.geometry;

public class Point {

	private final float x;
	private final float y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Point translate(float dx, float dy) {
		return new Point(x+dx, y+dy);
	}
}
