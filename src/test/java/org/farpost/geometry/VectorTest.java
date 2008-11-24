package org.farpost.geometry;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VectorTest {

	@Test
	public void testCalculateEndPoint() {
		Vector vector = new Vector(-90, 10);
		Point point = vector.calculateEndPoint(new Point(0, 0));
		assertThat(point.getX(), equalTo(0f));
		assertThat(point.getY(), equalTo(10f));
	}
}
