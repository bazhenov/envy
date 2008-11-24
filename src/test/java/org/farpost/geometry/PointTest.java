package org.farpost.geometry;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class PointTest {

	@Test
	public void testGetCoordinates() {
		Point p = new Point(1, 2);
		assertThat(p.getX(), equalTo(1f));
		assertThat(p.getY(), equalTo(2f));
	}

	@Test
	public void testTranslate() {
		Point p = new Point(1, 2).translate(1, 2);
		assertThat(p.getX(), equalTo(2f));
		assertThat(p.getY(), equalTo(4f));
	}
}
