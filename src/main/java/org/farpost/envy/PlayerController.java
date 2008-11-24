package org.farpost.envy;

import org.farpost.geometry.Point;
import org.farpost.geometry.Vector;

/**
 * PlayerController �������� �������� ����������� ��������, �������
 * ������������ ��� ��������� ����������� � �������� �������� ������
 */
public class PlayerController {

	private final Player player;

	public PlayerController(Player player) {
		this.player = player;
	}

	/**
	 * ���������� ��������� ������ �� ��������� �������
	 *
	 * @param vector ������ ��������
	 * @throws InvalidMovementStrategy � ������ ���� ��������� �������� ���������
	 *                                 ����������� ����������
	 */
	public void moveBy(Vector vector) throws InvalidMovementStrategy {
		if ( vector.getModule() > player.getMaximumSpeed() ) {
			throw new InvalidMovementStrategy();
		}
		player.setMovementStrategy(new MovementStrategy.MoveByVector(vector));
	}
}
