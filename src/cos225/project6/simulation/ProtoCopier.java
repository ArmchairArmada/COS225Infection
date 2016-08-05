package cos225.project6.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Copies prototype versions of objects
 * 
 * @author Nathan
 *
 */
public class ProtoCopier {
	Map<String, Copyable> prototypes;
	
	/**
	 * Constructor
	 */
	public ProtoCopier() {
		prototypes = new HashMap<String, Copyable>();
	}
	
	/**
	 * Register a prototype
	 * 
	 * @param name  Name of the prototype object
	 * @param prototype  The prototype object
	 */
	public void regiseter(String name, Copyable prototype) {
		prototypes.put(name, prototype);
	}
	
	/**
	 * Remove a prototype if it is no longer needed
	 * 
	 * @param name  Name of prototype to remove
	 */
	public void remove(String name) {
		prototypes.remove(name);
	}
	
	/**
	 * Make a copy of a prototype object
	 * 
	 * @param name  Name associated with the prototype
	 * @return  New object that is a copy of the prototype
	 */
	public Object makeCopy(String name) {
		return prototypes.get(name).copy();
	}
}
