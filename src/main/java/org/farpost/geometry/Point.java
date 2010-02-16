package org.farpost.geometry;

import static java.lang.Math.sqrt;

/**
 * Класс описывающий точку в двумерном пространстве.
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
	 * Перенос точки
	 *
	 * @param dx смещение по оси x
	 * @param dy смещение по оси y
	 * @return новая точка
	 */
	public Point translate(float dx, float dy) {
		return new Point(x + dx, y + dy);
	}

	/**
	 * Вычисляет расстояние до точки
	 *
	 * @param point точка
	 * @return расстояние
	 */
	public float getDistanceTo(Point point) {
		float dy = point.getY() - getY();
		float dx = point.getX() - getX();
		return (float) sqrt(dx * dx + dy * dy);
	}
}
