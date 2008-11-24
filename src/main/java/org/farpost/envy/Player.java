package org.farpost.envy;

import org.farpost.geometry.Point;
import org.farpost.geometry.Vector;

import static java.lang.StrictMath.random;

public class Player {

	private volatile Point location;

	public Player(Point location) {
		this.location = location;
	}

	public Point getLocation() {
		return location;
	}

	public void move(Point newLocation) {
		location = newLocation;
	}

	public Vector getSpeedVector() {
		synchronized ( this ) {
			// генерируем угол -90..90
			float angle = (float)random()*180f - 90;
			return new Vector(angle, 2);
		}
	}
}
