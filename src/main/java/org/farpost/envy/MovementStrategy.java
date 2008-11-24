package org.farpost.envy;

import org.farpost.geometry.Point;
import org.farpost.geometry.Vector;

/**
 * Стратегия расчета движения.
 */
public interface MovementStrategy {

	/**
	 * Этот метод определяет координаты следующей точки положения игрока
	 * основываясь на координатах текущего положения.
	 *
	 * @param location текужее положение игрока
	 * @return координаты его следующего положения
	 */
	Point calculateNextPoint(Point location);

	/**
	 * Эта стратегия просто возвращает текущее местоположение игрока
	 */
	public static class StayOnPlace implements MovementStrategy {

		public Point calculateNextPoint(Point location) {
			return location;
		}
	}

	/**
	 * Стратегия движения "по вектору"
	 */
	public class MoveByVector implements MovementStrategy {

		private final Vector vector;

		public MoveByVector(Vector vector) {
			this.vector = vector;
		}

		public Point calculateNextPoint(Point location) {
			return vector.calculateEndPoint(location);
		}
	}
}
