package cos225.project6.math;

public class Units {
	/**
     * Convert the Turtle's heading value into a Radians value. <br /> <br />
     * 
     * Turtle Heading uses 12 O'Clock as Heading 0 and rotates clockwise.
     * Sine and Cosine use 3 O'Clock at 0 Radians and rotates counter-clockwise.
     * This converts Heading into something that can be used with Sine and Cosine. <br /> <br />
     * 
     * Pre: <br />
	 * Post:
	 * 
     * @param heading  Turtle heading
     * @return  Radians
     */
	public static double headingToRadians(double heading) {
    	return Math.toRadians(90.0 - heading);
    }
	
	/**
	 * Convert radians to Turtle's heading value <br /> <br />
	 * 
	 * pre: <br />
	 * post:
	 * 
	 * @param radians
	 * @return heading
	 */
	public static double radiansToHeading(double radians) {
    	return 90 - Math.toDegrees(radians);
    }
}
