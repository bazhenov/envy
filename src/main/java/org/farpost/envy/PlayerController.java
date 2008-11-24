package org.farpost.envy;

import org.farpost.geometry.Point;
import org.farpost.geometry.Vector;

import static java.lang.StrictMath.random;

public class PlayerController {

	private volatile Point location;
	private volatile Vector movementVecor;

	public PlayerController(Point location) {
		this.location = location;
	}

	public Point getLocation() {
		return location;
	}

	public void move(Point newLocation) {
		location = newLocation;
	}

	public Vector getMovementVector() {
		return movementVecor;
	}

	public void moveBy(Vector vector) {
		movementVecor = vector;
	}
}
