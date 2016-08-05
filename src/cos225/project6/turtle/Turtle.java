package cos225.project6.turtle;

import cos225.project6.simulation.EntityPopulation;
import cos225.project6.math.Units;
import cos225.project6.math.ValueWrapper;
import cos225.project6.simulation.Entity;


/**
 * Basic Turtle entity
 * 
 * @author Nathan
 *
 */
public class Turtle extends Entity {
	protected double heading = 0;
	private static ValueWrapper headingWrap = new ValueWrapper(0, 360); 
	
	/**
    * Create a new Turtle with heading due north (0 degrees), and 
    * position at the origin (0,0)
    */
    public Turtle(EntityPopulation population) {
    	super(population);
		setHeading(0);
    }

    /**
     * Create a new Turtle with specified heading and position
     * 
     * @param inith  Starting heading for the turtle 
     * @param x  Starting X coordinate for the turtle
     * @param y  Starting Y coordinate for the turtle
     */
    public Turtle (EntityPopulation population, double inith, double x, double y) {
    	super(population);
    	position.set(x, y);
    	setHeading(inith);
    }
    
    public Turtle copy() {
    	return new Turtle(population, heading(), position.getX(), position.getY());
    }
    
    @Override
    public void cleanup() {
    	super.cleanup();
    }

    /**
     * Create a new Turtle with specified heading and 
     * position at the origin (0,0)
     * 
     * @param inith  Starting heading for the turtle
     */
    public Turtle (EntityPopulation population, double inith) {
    	super(population);
    	setHeading(inith);
    }

    /**
     * Create a new Turtle with heading due north (0 degrees) and 
     * specified position
     * 
     * @param x  Starting X coordinate
     * @param y  Starting Y coordinate
     */
    public Turtle (EntityPopulation population, double x, double y) {
    	super(population);
    	position.set(x, y);
    	setHeading(0.0);
    }

    // Commands:

    /**
     * Reset the turtle to x y-coordinate position. <br /> <br />
     * 
     * Pre: <br />
	 * Post:  BASICTURTLE.x = x
	 * 
     * @param x  New X coordinate
     */
    public void setx (double x) {
    	position.setX(x);
    }

    /**
     * Reset the turtle to y y-coordinate position. <br /> <br />
     * 
     * Pre: <br />
	 * Post:  BASICTURTLE.y = y
	 * 
     * @param y  New Y coordinate
     */
    public void sety (double y) {
    	position.setY(y);
    }  

    /**
     * Reset the turtle to tHeading. <br /> <br />
     * 
     * Pre: <br />
	 * Post:  BASICTURTLE.heading = heading
	 * 
     * @param tHeading  New heading
     */
    public void setHeading (double tHeading) {
    	heading = Turtle.headingWrap.wrap(tHeading);
    	angle = Units.headingToRadians(heading);
    }


    /**
     * Turn right offset degrees. The turtle heading is changed but the
     * turtle position stays the same.  
     * offset can be any positive or negative value.  
     * The calculation is done % 360 degrees.
     * rt is exactly the opposite of lt. <br /> <br />
     * 
     * pre: <br />
     * post: HEADING' = (HEADING + offset) % 360
     * 
     * @param offset  Relative right rotation for heading
     */
    public void rt (double offset) {
    	setHeading(heading + offset);
    }

    /**
     * Turn left offset degrees. The turtle heading is changed but the
     * turtle position stays the same.  
     * offset can be any positive or negative value.  
     * The calculation is done % 360 degrees.
     * lt is exactly the opposite of rt. <br /> <br />
     * 
     * pre: <br />
     * post: HEADING' = (HEADING - offset) % 360
     * 
     * @param offset  Relative left rotation for heading
     */
    public void lt (double offset) {
    	setHeading(heading - offset);
    }

    /**
     * Move forward dist steps in the direction of the turtle's heading.
     * fd is exactly the opposite of bk.  The turtle position
     * is changed but the turtle heading stays the same. <br /> <br />
     * 
     * Pre: <br />
	 * Post:  Turtle's position moved dist distance along heading
	 * 
     * @param dist  Distance to travel forwards
     */
    public void fd (double dist) {
    	position.translate(angle, dist);
    }

    /**
     * Move backward dist steps.  bk is exactly the opposite of fd.  The turtle position
     * is changed but the turtle heading stays the same. <br /> <br />
     * 
     * Pre: <br />
	 * Post:  Turtle's position moved dist distance along opposite of heading
	 * 
     * Distance to travel backwards
     */
    public void bk (double dist) {
    	fd(-dist);
    }

    // Queries:

    /**
     * Current heading of this turtle in degrees, 0 to < 360, with 0 due north. <br /> <br />
     * 
     * Pre: <br />
	 * Post:
	 * 
     * @return  Turtle's current heading
     */
    public double heading () {
    	return heading;
    }

    /**
     * Current x position of the turtle. <br /> <br />
     * 
     * Pre: <br />
	 * Post:
	 * 
     * @return  Turtle's current X coordinate
     */
    public double xcor () {
    	return position.getX();
    }

    /**
     * Current y position of the turtle. <br /> <br />
     * 
     * Pre: <br />
	 * Post:
	 * 
     * @return  Turtle's current Y coordinate
     */
    public double ycor () {
    	return position.getY();
    }
    
    /**
     * String representation of internal state, useful for debugging.
     */
    public String toString() {
    	return "Turtle(position=" + position + ", heading=" + heading + ")";
    }
}
