package org.farpost.geometry;

import static java.lang.Math.sqrt;

/**
 * ����� ����������� ����� � ��������� ������������.
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
	 * ������� �����
	 *
	 * @param dx �������� �� ��� x
	 * @param dy �������� �� ��� y
	 * @return ����� �����
	 */
	public Point translate(float dx, float dy) {
		return new Point(x + dx, y + dy);
	}

	/**
	 * ��������� ���������� �� �����
	 *
	 * @param point �����
	 * @return ����������
	 */
	public float getDistanceTo(Point point) {
		float dy = point.getY() - getY();
		float dx = point.getX() - getX();
		return (float) sqrt(dx * dx + dy * dy);
	}
}
