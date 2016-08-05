package cos225.project6.math;

/**
 * Wrapps double values to be within a specified min and max value range
 * 
 * @author Nathan
 *
 */
public class ValueWrapper {
	double min;
	double max;
	double span;
	
	/**
	 * Create value wrapper using specified min and max boundary values
	 * 
	 * @param min  The lower bound of the value range
	 * @param max  Tue upper bound of the value range
	 */
	public ValueWrapper(double min, double max) {
		this.min = min;
		this.max = max;
		span = max - min;
	}
	
	/**
	 * Wraps a value so that it will be within min and max
	 *  
	 * @param value  Value to wrap
	 * @return  Value that has been wrapped to be within min and max
	 */
	public double wrap(double value) {
		if (value < min || value >= max)
			return value - span * Math.floor(value / span);
		return value;
	}
}
