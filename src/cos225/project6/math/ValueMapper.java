package cos225.project6.math;

/**
 * Maps double values by scaling then offsetting them to find a new value
 * 
 * @author Nathan
 *
 */
public class ValueMapper {
	private double scale = 1.0;
	private double offset = 0.0;
	
	/**
	 * Constructor to create ValueMapper that uses specified scale and offset <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @param scale  What a value should be multiplied by
	 * @param offset  What value should be added to the scaled value
	 */
	public ValueMapper(double scale, double offset) {
		this.scale = scale;
		this.offset = offset;
	}
	
	/**
	 * Maps a value onto a new value by scaling then offsetting <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @param value  Value user wants to have mapped
	 * @return  Value after scaling and offsetting
	 */
	public double map(double value) {
		return value * scale + offset;
	}
}
