package org.farpost.geometry;

import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

public class Vector {

	private final double xAngle;
	private final double yAngle;
	private final float force;

	public Vector(float angle, float force) {
		this.xAngle = toRadians(angle);
		this.yAngle = toRadians(angle+90);
		this.force = force;
	}

	public Point calculateEndPoint(Point point) {
		float dx = ((float)cos(xAngle) * force) + point.getX();
		float dy = ((float)cos(yAngle) * force) + point.getY();
		return new Point(dx, dy);
	}
}
