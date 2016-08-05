package cos225.project6.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cos225.project6.math.Vector2D;

public class Vector2DTest {

	@Test
	public void testVector2D() {
		Vector2D v = new Vector2D();
		assertEquals(v.getX(), 0.0, 0.001);
		assertEquals(v.getY(), 0.0, 0.001);
	}

	@Test
	public void testVector2DDoubleDouble() {
		Vector2D v = new Vector2D(10.0, -20.0);
		assertEquals(v.getX(), 10.0, 0.001);
		assertEquals(v.getY(), -20.0, 0.001);
	}

	@Test
	public void testVector2DVector2D() {
		Vector2D v1 = new Vector2D(10.0, -20.0);
		Vector2D v2 = new Vector2D(v1);
		
		assertEquals(v1.getX(), v2.getX(), 0.001);
		assertEquals(v1.getY(), v2.getY(), 0.001);
	}
	
	@Test
	public void testCopy() {
		Vector2D v1 = new Vector2D(10.0, -20.0);
		Vector2D v2 = v1.copy();
		
		assertEquals(v1.getX(), v2.getX(), 0.001);
		assertEquals(v1.getY(), v2.getY(), 0.001);
	}

	@Test
	public void testGetX() {
		Vector2D v = new Vector2D(10.0, -20.0);
		assertEquals(v.getX(), 10.0, 0.001);
	}

	@Test
	public void testGetY() {
		Vector2D v = new Vector2D(10.0, -20.0);
		assertEquals(v.getY(), -20.0, 0.001);
	}

	@Test
	public void testSetX() {
		Vector2D v = new Vector2D();
		v.setX(100.0);
		assertEquals(v.getX(), 100.0, 0.001);
	}

	@Test
	public void testSetY() {
		Vector2D v = new Vector2D();
		v.setY(100.0);
		assertEquals(v.getY(), 100.0, 0.001);
	}

	@Test
	public void testSet() {
		Vector2D v = new Vector2D();
		v.set(10.0, -20.0);
		
		assertEquals(v.getX(), 10.0, 0.001);
		assertEquals(v.getY(), -20.0, 0.001);
	}

	@Test
	public void testMagnitude() {
		Vector2D v = new Vector2D(3, 4);
		assertEquals(v.magnitude(), 5.0, 0.001);
	}

	@Test
	public void testNormalize() {
		Vector2D v = new Vector2D(3, 4);
		v.normalize();
		assertEquals(v.magnitude(), 1.0, 0.001);
		assertEquals(v.getX(), 0.6, 0.001);
		assertEquals(v.getY(), 0.8, 0.001);
	}

	@Test
	public void testDot() {
		Vector2D v1 = new Vector2D(-6, 8);
		Vector2D v2 = new Vector2D(5, 12);
		assertEquals(v1.dot(v2), 66, 0.001);
	}

	@Test
	public void testEqualsVector2D() {
		Vector2D v1 = new Vector2D(10.0, -20.0);
		Vector2D v2 = new Vector2D(10.0, -20.0);
		Vector2D v3 = new Vector2D(-100.0, 200.0);
		
		assert(v1.equals(v2));
		assert(!v1.equals(v3));
	}

	@Test
	public void testAdd() {
		Vector2D v1 = new Vector2D(1.0, 0.0);
		Vector2D v2 = new Vector2D(0.0, 1.0);
		v1.add(v2);
		assertEquals(v1.getX(), 1, 0.001);
		assertEquals(v1.getY(), 1, 0.001);
	}

	@Test
	public void testSubtract() {
		Vector2D v1 = new Vector2D(1.0, 0.0);
		Vector2D v2 = new Vector2D(0.0, 1.0);
		v1.subtract(v2);
		assertEquals(v1.getX(), 1, 0.001);
		assertEquals(v1.getY(), -1, 0.001);
	}

	@Test
	public void testMultiply() {
		Vector2D v1 = new Vector2D(2.0, 3.0);
		Vector2D v2 = new Vector2D(4.0, 5.0);
		v1.multiply(v2);
		assertEquals(v1.getX(), 8, 0.001);
		assertEquals(v1.getY(), 15, 0.001);
	}

	@Test
	public void testDivide() {
		Vector2D v1 = new Vector2D(4.0, 6.0);
		Vector2D v2 = new Vector2D(2.0, 3.0);
		v1.divide(v2);
		assertEquals(v1.getX(), 2, 0.001);
		assertEquals(v1.getY(), 2, 0.001);
	}

	@Test
	public void testScale() {
		Vector2D v = new Vector2D(10, -20);
		v.scale(2.0);
		assertEquals(v.getX(), 20, 0.001);
		assertEquals(v.getY(), -40, 0.001);
	}

	@Test
	public void testTranslate() {
		Vector2D v = new Vector2D(2, 3);
		v.translate(0, 1);
		assertEquals(v.getX(), 3, 0.001);
		assertEquals(v.getY(), 3, 0.001);
		
		v.translate(Math.PI/2, 1);
		assertEquals(v.getX(), 3, 0.001);
		assertEquals(v.getY(), 4, 0.001);
	}

	@Test
	public void testAngle() {
		Vector2D v = new Vector2D(1, 1);
		assertEquals(v.angle(), Math.PI/4, 0.001);
	}

	@Test
	public void testAngleVector2D() {
		Vector2D v1 = new Vector2D(-6, 8);
		Vector2D v2 = new Vector2D(5, 12);
		assertEquals(v1.angle(v2), 1.038, 0.001);
	}

	@Test
	public void testRotate() {
		Vector2D v = new Vector2D(1, 0);
		v.rotate(Math.PI / 2);
		assertEquals(v.getX(), 0, 0.001);
		assertEquals(v.getY(), 1, 0.001);
		
		v.rotate(-Math.PI);
		assertEquals(v.getX(), 0, 0.001);
		assertEquals(v.getY(), -1, 0.001);
	}

}
