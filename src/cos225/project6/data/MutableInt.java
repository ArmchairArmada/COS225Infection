package cos225.project6.data;

/**
 * Model: Stores an integer value in a mutable object
 * 
 * @author Nathan
 *
 */
public class MutableInt {
	private int value=0;
	
	/**
	 * Default constructor <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: this.get() = 0
	 */
	public MutableInt () {
	}
	
	/**
	 * Constructor that allows you to specify starting <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: this.get() = value
	 * 
	 * @param value
	 */
	public MutableInt(int value) {
		this.value = value;
	}
	
	/**
	 * Set the value of the integer <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: this.get() = value
	 * 
	 * @param value
	 */
	public void set(int value) {
		this.value = value;
	}
	
	/**
	 * Get the current value of the integer <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: 
	 * 
	 * @return  The current value of the integer
	 */
	public int get() {
		return value;
	}
	
	/**
	 * Increment the integer value <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: this.get() = this.get() + 1
	 */
	public void inc() {
		value++;
	}
	
	/**
	 * Decrement the integer value <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: this.get() = this.get() - 1
	 */
	public void dec() {
		value--;
	}
}
