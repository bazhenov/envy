package org.farpost.geometry;

import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

/**
 * Класс описывающий вектор. Вектор описывается направляющим углом
 * и модулем вектора. Направляющий угол отсчитывается от положительной оси X.
 * <pre>
 *          90
 *          ^ (y)
 *          |
 *          |       (x)
 * 180 -----+------> 0
 *          |
 *          |
 *         240
 * </pre>
 */
public class Vector {

	private final double xAngle;
	private final double yAngle;
	private final float module;
	private final float angle;

	/**
	 * @param angle  направляющий угол в градусах
	 * @param module модуль вектора
	 */
	public Vector(float angle, float module) {
		this.xAngle = toRadians(angle);
		this.yAngle = toRadians(angle + 90);
		this.module = module;
		this.angle = angle;
	}

	public float getModule() {
		return module;
	}

	public float getAngle() {
		return angle;
	}

	/**
	 * Вычисляет координаты конца вектора приложенного к заданной точке начала
	 *
	 * @param point координаты начала вектора
	 * @return координаты конца вектора
	 */
	public Point calculateEndPoint(Point point) {
		float dx = ((float) cos(xAngle) * module) + point.getX();
		float dy = ((float) cos(yAngle) * module) + point.getY();
		return new Point(dx, dy);
	}
}
