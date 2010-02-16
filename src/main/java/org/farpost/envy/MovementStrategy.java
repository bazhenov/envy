package org.farpost.envy;

import org.farpost.geometry.Point;
import org.farpost.geometry.Vector;

/**
 * Стратегия расчета движения.
 */
interface MovementStrategy {

	/**
	 * Этот метод определяет координаты следующей точки положения игрока
	 * основываясь на координатах текущего положения.
	 *
	 * @param location текущее положение игрока
	 * @return координаты его следующего положения
	 */
	Point calculateNextPoint(Point location);

	/**
	 * Эта стратегия просто возвращает текущее местоположение игрока
	 */
	static class StayOnPlace implements MovementStrategy {

		public Point calculateNextPoint(Point location) {
			return location;
		}
	}

	/**
	 * Стратегия движения "по вектору"
	 */
	class MoveByVector implements MovementStrategy {

		private final Vector vector;

		public MoveByVector(Vector vector) {
			this.vector = vector;
		}

		public Point calculateNextPoint(Point location) {
			return vector.calculateEndPoint(location);
		}
	}
}
