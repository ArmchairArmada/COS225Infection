package cos225.project6.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cos225.project6.math.Units;

public class UnitsTest {

	@Test
	public void testHeadingToRadians() {
		assertEquals(Units.headingToRadians(0), Math.PI / 2, 0.001);
		assertEquals(Units.headingToRadians(90), 0, 0.001);
	}

	@Test
	public void testRadiansToHeading() {
		assertEquals(Units.radiansToHeading(Math.PI / 2), 0, 0.001);
		assertEquals(Units.radiansToHeading(0), 90, 0.001);
	}

}
