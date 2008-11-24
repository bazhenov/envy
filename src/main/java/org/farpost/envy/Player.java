package org.farpost.envy;

import org.farpost.geometry.Point;

public class Player {

	private volatile Point location;
	private volatile float maximumSpeed;
	private volatile MovementStrategy movementStrategy;

	public Player(Point location, float maximumSpeed) {
		this.location = location;
		this.maximumSpeed = maximumSpeed;
		movementStrategy = new MovementStrategy.StayOnPlace();
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Point getLocation() {
		return location;
	}

	public float getMaximumSpeed() {
		return maximumSpeed;
	}

	public void setMaximumSpeed(float maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}

	public MovementStrategy getMovementStrategy() {
		return movementStrategy;
	}

	public void setMovementStrategy(MovementStrategy movementStrategy) {
		this.movementStrategy = movementStrategy;
	}
}
