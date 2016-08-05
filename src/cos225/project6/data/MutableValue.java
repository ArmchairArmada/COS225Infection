package cos225.project6.data;

/**
 * Provides a means of having mutable versions of non-mutable objects.
 * 
 * @author Nathan
 *
 * @param <T>  The object type
 */
public class MutableValue<T> {
	private T value;
	
	/**
	 * Initialize with a starting value 
	 * 
	 * post: getValue() = value
	 * 
	 * @param value  Starting value
	 */
	public MutableValue(T value) {
		this.value = value;
	}
	
	/**
	 * Get the value
	 * 
	 * @return  The value
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * Set the value
	 * 
	 * post: getValue() = value
	 * 
	 * @param value
	 */
	public void setValue(T value) {
		this.value = value;
	}
}
