package cos225.project6.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cos225.project6.turtle.Turtle;


public class BasicTurtleTest {
	@Test
	public void testBasicTurtle() {
		Turtle t = new Turtle(null);
		assertEquals(t.heading(), 0, 0.001);
		assertEquals(t.xcor(), 0, 0.001);
		assertEquals(t.ycor(), 0, 0.001);
	}

	@Test
	public void testBasicTurtleDoubleDoubleDouble() {
		Turtle t = new Turtle(null,10,20,30);
		assertEquals(t.heading(), 10, 0.001);
		assertEquals(t.xcor(), 20, 0.001);
		assertEquals(t.ycor(), 30, 0.001);
	}

	@Test
	public void testBasicTurtleDouble() {
		Turtle t = new Turtle(null,10);
		assertEquals(t.heading(), 10, 0.001);
	}

	@Test
	public void testBasicTurtleDoubleDouble() {
		Turtle t = new Turtle(null,20,30);
		assertEquals(t.xcor(), 20, 0.001);
		assertEquals(t.ycor(), 30, 0.001);
	}

	@Test
	public void testSetx() {
		Turtle t = new Turtle(null);
		t.setx(100);
		assertEquals(t.xcor(), 100, 0.001);
	}

	@Test
	public void testSety() {
		Turtle t = new Turtle(null);
		t.sety(100);
		assertEquals(t.ycor(), 100, 0.001);
	}

	@Test
	public void testSetHeading() {
		Turtle t = new Turtle(null);
		t.setHeading(100);
		assertEquals(t.heading(), 100, 0.001);
	}

	@Test
	public void testRt() {
		Turtle t = new Turtle(null);
		t.rt(90);
		assertEquals(t.heading(), 90, 0.001);
		t.rt(90);
		assertEquals(t.heading(), 180, 0.001);
	}

	@Test
	public void testLt() {
		Turtle t = new Turtle(null);
		t.lt(90);
		assertEquals(t.heading(), 270, 0.001);
		t.lt(90);
		assertEquals(t.heading(), 180, 0.001);
	}

	@Test
	public void testFd() {
		Turtle t = new Turtle(null);
		t.fd(10);
		assertEquals(t.ycor(), 10, 0.001);
	}

	@Test
	public void testBk() {
		Turtle t = new Turtle(null);
		t.bk(10);
		assertEquals(t.ycor(), -10, 0.001);
	}

	@Test
	public void testHeading() {
		Turtle t = new Turtle(null);
		assertEquals(t.heading(), 0, 0.001);
	}

	@Test
	public void testXcor() {
		Turtle t = new Turtle(null);
		assertEquals(t.xcor(), 0, 0.001);
	}

	@Test
	public void testYcor() {
		Turtle t = new Turtle(null);
		assertEquals(t.ycor(), 0, 0.001);
	}

}
