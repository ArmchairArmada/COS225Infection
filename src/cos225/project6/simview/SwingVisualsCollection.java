package cos225.project6.simview;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Collection of visuals that can be drawn all together
 * 
 * @author Nathan
 *
 */
public class SwingVisualsCollection {
	private List<SwingVisual> visuals;
	
	/**
	 * Constructor
	 */
	public SwingVisualsCollection() {
		visuals = new ArrayList<SwingVisual>();
	}
	
	/**
	 * Add a visual to the collection
	 * 
	 * @param visual  Visual to add
	 */
	public void add(SwingVisual visual) {
		visuals.add(visual);
	}
	
	/**
	 * Remove a visual
	 * 
	 * @param visual  Visual to remove
	 */
	public void remove(SwingVisual visual) {
		visuals.remove(visual);
	}
	
	/**
	 * Draw all of the visuals
	 * 
	 * @param g  Graphics object to draw with
	 */
	public void draw(Graphics g) {
		for (SwingVisual visual: visuals) {
			visual.draw(g);
		}
	}
}
