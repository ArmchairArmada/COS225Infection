package cos225.project6.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cos225.project6.math.ValueWrapper;

public class ValueWrapperTest {

	@Test
	public void test() {
		ValueWrapper vw = new ValueWrapper(-100, 100);
		assertEquals(vw.wrap(200), 0, 0.001);
		assertEquals(vw.wrap(-150.5), 49.5, 0.001);
		
		assertEquals(vw.wrap(10000), 0, 0.00001);
	}

}
