package org.farpost.geometry;

import static java.lang.Math.sqrt;

/**
 *  ласс описывающий точку в двумерном пространстве.
 */
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

	/**
	 * ѕеренос точки
	 *
	 * @param dx смещение по оси x
	 * @param dy смещение по оси y
	 * @return нова€ точка
	 */
	public Point translate(float dx, float dy) {
		return new Point(x + dx, y + dy);
	}

	/**
	 * ¬ычисл€ет рассто€ние до точки
	 *
	 * @param point точка
	 * @return рассто€ние
	 */
	public float getDistanceTo(Point point) {
		float dy = point.getY() - getY();
		float dx = point.getX() - getX();
		return (float) sqrt(dx * dx + dy * dy);
	}
}
