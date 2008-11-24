package org.farpost.envy;

import org.farpost.geometry.Point;
import org.farpost.geometry.Vector;

/**
 * PlayerController является основным управляющий обьектом, который
 * используется для изменения направления и скорости движения игрока
 */
public class PlayerController {

	private final Player player;

	public PlayerController(Player player) {
		this.player = player;
	}

	/**
	 * Заставляет двигаться игрока по заданному вектору
	 *
	 * @param vector вектор движения
	 * @throws InvalidMovementStrategy в случае если указанная скорость превыжает
	 *                                 максимально допустимую
	 */
	public void moveBy(Vector vector) throws InvalidMovementStrategy {
		if ( vector.getModule() > player.getMaximumSpeed() ) {
			throw new InvalidMovementStrategy();
		}
		player.setMovementStrategy(new MovementStrategy.MoveByVector(vector));
	}
}
