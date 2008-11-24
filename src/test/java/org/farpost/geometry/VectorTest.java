package org.farpost.geometry;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import static java.lang.StrictMath.round;

public class VectorTest {

	@Test
	public void testCalculateEndPoint() {
		Vector vector = new Vector(-90, 10);
		Point point = vector.calculateEndPoint(new Point(0, 0));

		/**
		 *   сожалению, в java все тригонометрические операции производ€тс€
		 * в радианах. »з-за этого, например, cos(90) (в градусах) не равен точно 0.
		 * ѕоэтому в этом тесте мы округл€ем полученное значение по координте x.
		 */
		float x = round(point.getX()*100)/100;
		float y = point.getY();

		assertThat(x, equalTo(0f));
		assertThat(y, equalTo(10f));
	}
}
