package cos225.project6.math;

import java.util.Random;

/**
 * Provides easy global access to a random number generator
 * 
 * @author Nathan
 *
 */
public class Rand {
	static final Random random = new Random();
	
	/**
	 * Get the random number generator
	 * @return  Random number generator
	 */
	public static Random getRandom() {
		return random;
	}
}
