package org.farpost.envy;

import org.farpost.geometry.Point;
import org.farpost.geometry.Vector;

/**
 * ��������� ������� ��������.
 */
public interface MovementStrategy {

	/**
	 * ���� ����� ���������� ���������� ��������� ����� ��������� ������
	 * ����������� �� ����������� �������� ���������.
	 *
	 * @param location ������� ��������� ������
	 * @return ���������� ��� ���������� ���������
	 */
	Point calculateNextPoint(Point location);

	/**
	 * ��� ��������� ������ ���������� ������� �������������� ������
	 */
	public static class StayOnPlace implements MovementStrategy {

		public Point calculateNextPoint(Point location) {
			return location;
		}
	}

	/**
	 * ��������� �������� "�� �������"
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
