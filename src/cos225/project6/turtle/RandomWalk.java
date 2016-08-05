package cos225.project6.turtle;

import cos225.project6.math.Rand;


/**
 * Random Turtle walk behavior
 * 
 * @author Nathan
 *
 */
public class RandomWalk {
	private Turtle turtle = null;
	private double turnAmount;
	private double stepSize;
	
	/**
	 * Constructor
	 * 
	 * @param turtle  Turtle to move around
	 * @param turnAmount  Amount to randomly turn left and right
	 * @param stepSize  Size of step forward
	 */
	public RandomWalk(Turtle turtle, double turnAmount, double stepSize) {
		this.turtle = turtle;
		this.turnAmount = turnAmount;
		this.stepSize = stepSize;
	}
	
	/**
	 * Makes the turtle randomly walk.  A timeDelta is provided to allow
	 * for the option to display smooth frame rate independent animation
	 * of moving Turtles. <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: Turtle's heading has been randomly updated and position moved forward
	 * 
	 * @param timeDelta  Amount of time passed since last update
	 */
	public void update(double timeDelta) {
		turtle.rt(Rand.getRandom().nextDouble() * turnAmount * timeDelta);
		turtle.lt(Rand.getRandom().nextDouble() * turnAmount * timeDelta);
		turtle.fd(stepSize * timeDelta);
	}
}
