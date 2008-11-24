package org.farpost.envy;

import org.farpost.geometry.Vector;

import static java.lang.Thread.sleep;
import static java.lang.Math.random;

public class PlayerBehaviourImpl implements PlayerBehaviour {

	private final PlayerController controller;

	public PlayerBehaviourImpl(PlayerController controller) {
		this.controller = controller;
	}

	public void run() {
		while ( true ) {
			float angle = (float)random()*360;
			controller.moveBy(new Vector(angle, 1));
			try {
				sleep(2000);
			} catch ( InterruptedException e ) {
				throw new RuntimeException(e);
			}
		}
	}
}
