package org.farpost.envy;

import org.farpost.geometry.Vector;

import static java.lang.Thread.sleep;
import static java.lang.Math.random;

/**
 * ѕроста€ имплементаци€ PlayerBehaviour, котора€
 * мен€ет направление движени€ игрока каждую секунду
 */
public class PlayerBehaviourImpl implements PlayerBehaviour {

	private final PlayerController controller;

	public PlayerBehaviourImpl(PlayerController controller) {
		this.controller = controller;
	}

	public void run() {
		while ( true ) {
			float angle = (float)random()*360;
			try {
				controller.moveBy(new Vector(angle, 1));
			} catch ( InvalidMovementStrategy e ) {
				throw new RuntimeException(e);
			}
			try {
				sleep(1000);
			} catch ( InterruptedException e ) {
				throw new RuntimeException(e);
			}
		}
	}
}
