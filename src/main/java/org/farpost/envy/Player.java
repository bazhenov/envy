package org.farpost.envy;

import org.farpost.geometry.Vector;
import org.farpost.geometry.Point;

public class Player {

	private volatile Point location;
	private int x = 0;

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
			return new Vector(90, 2);
		}
	}
}
