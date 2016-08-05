package cos225.project6.math;

/**
 * 2D vector math data structure with common operations for setting, getting, adding,
 * subtracting, multiplying, dividing, scaling, getting the magnatude, normalizing,
 * finding the dot product, checking equality, moving end at a given angle and distance,
 * getting the angle of the vector, getting the angle between this vector and another,
 * and rotating the vector. <br /> <br />
 * 
 * Not all these features might have been necessary, but they were quick to implement
 * so they were added in -- just in case they might be useful in the future.
 * 
 * @author Nathan
 *
 */
public class Vector2D {
	private double x;
	private double y;
	
	/**
	 * Initialized to X and Y being zero.
	 */
	public Vector2D() {
		x = 0.0;
		y = 0.0;
	}
	
	/**
	 * Initializes with specified x and y values. <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  Vector2D initialized with x and y
	 * 
	 * @param x  X component of the vector
	 * @param y  Y component of the vector
	 */
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Copy constructor <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  Vector2D initialized with copied values from vector
	 * 
	 * @param vector  Vector to copy
	 */
	public Vector2D(Vector2D vector) {
		x = vector.x;
		y = vector.y;
	}
	
	/**
	 * Copy function <br /> <br />
	 * 
	 * pre: <br />
	 * post:
	 * 
	 * @return  Copy of this Vector2D
	 */
	public Vector2D copy() {
		return new Vector2D(this);
	}
	
	/**
	 * Query the X component <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @return  Value of the X part of the vector
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Query the Y component <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @return  Value of the Y part of the vector
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Set the X component to specified value <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR2D.x set to value
	 * 
	 * @param value  New value for the X part
	 */
	public void setX(double value) {
		x = value;
	}
	
	/**
	 * Set the Y component to specified value <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR2D.y set to value
	 * 
	 * @param value  New value for the Y part
	 */
	public void setY(double value) {
		y = value;
	}
	
	/**
	 * Set both the X and Y values <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR.x set to x and VECTOR.y set to y
	 * 
	 * @param x  New value for the X part
	 * @param y  New vlaue for the Y part
	 */
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Compute the magnitude of the vector <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @return  The magnitude (or length) of the vector.
	 */
	public double magnitude() {
		return Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Normalize the vector to be of length one (in place). <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  Vector scaled so its magnitude = 1
	 */
	public void normalize() {
		double mag = magnitude();
		x /= mag;
		y /= mag;
	}
	
	/**
	 * Compute the dot product of this vector and another. <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @param vector  The other vector to use
	 * @return  The dot product
	 */
	public double dot(Vector2D vector) {
		return x*vector.x + y*vector.y;
	}
	
	/**
	 * Checks equality between this vector and another <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @param vector  The vector to compare against
	 * @return  True if equal, False if not
	 */
	public boolean equals(Vector2D vector) {
		return x == vector.x && y == vector.y;
	}
	
	/**
	 * Add a vector to this vector (in place) <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR2D.x += vector.x and VECTOR2D.y += vector.y
	 * 
	 * @param vector  The vector to add
	 */
	public void add(Vector2D vector) {
		x += vector.x;
		y += vector.y;
	}
	
	/**
	 * Subtract a vector from this vector (in place) <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR2D.x -= vector.x and VECTOR2D.y -= vector.y
	 * 
	 * @param vector  The vector to subtract
	 */
	public void subtract(Vector2D vector) {
		x -= vector.x;
		y -= vector.y;
	}
	
	/**
	 * Multiply a vector to this vector (in place) <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: VECTOR2D.x *= vector.x and VECTOR2D.y *= vector.y
	 * 
	 * @param vector  The vector to multiply by
	 */
	public void multiply(Vector2D vector) {
		x *= vector.x;
		y *= vector.y;
	}
	
	/**
	 * Divide this vector by another vector (in place) <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR2D.x /= vector.x and VECTOR.y /= vector.y
	 * 
	 * @param vector  The vector to divide by
	 */
	public void divide(Vector2D vector) {
		x /= vector.x;
		y /= vector.y;
	}
	
	/**
	 * Scale the vector (in place) <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR2D.x *= amount and VECTOR2D.y *= amount
	 * 
	 * @param amount  The scaling amount
	 */
	public void scale(double amount) {
		x *= amount;
		y *= amount;
	}
	
	/**
	 * Move the end of the vector by an amount at an angle (in place) <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR2D's x,y coordinate moved along the angle by the amount
	 * 
	 * @param angle  Angle in Radians to move the end of the vector
	 * @param amount  Amount to move it by
	 */
	public void translate(double angle, double amount) {
		x += amount * Math.cos(angle);
		y += amount * Math.sin(angle);
	}
	
	/**
	 * Compute the angle of the line <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @return  The angle of the line in Radians
	 */
	public double angle() {
		return Math.atan2(y, x);
	}
	
	/**
	 * Compute the angle between this vector and another <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @param vector  Vector use for finding in between angle
	 * @return  The angle between this vector and another in Radians
	 */
	public double angle(Vector2D vector) {
		return Math.acos(dot(vector) / (magnitude() * vector.magnitude()));
	}
	
	/**
	 * Rotate a point by a given angle (in place) <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:  VECTOR2D's x,y coordinate rotated around origin by angle amount
	 * 
	 * @param angle  Amount to rotate by in Radians
	 */
	public void rotate(double angle) {
		double newX = x * Math.cos(angle) - y * Math.sin(angle);
		double newY = x * Math.sin(angle) + y * Math.cos(angle);
		
		x = newX;
		y = newY;
	}
	
	/**
	 * String representation of object
	 * 
	 * @return String in the form "Vector2D(x, y)"
	 */
	public String toString() {
		return "Vector2D(" + x + ", " + y + ")";
	}
}
