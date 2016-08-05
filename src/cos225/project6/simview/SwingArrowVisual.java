package cos225.project6.simview;

import java.awt.Graphics;
import cos225.project6.math.Vector2D;

/**
 * An arrow that can be drawn onto a JPanel.
 * 
 * This can probably be improved, like by sharing point lists instead of
 * creating the shape for each visual. 
 * 
 * @author Nathan
 *
 */
public class SwingArrowVisual extends SwingVisual {
	private Vector2D[] points;
	private double angle = 0.0;
	
	/**
	 * Constructor
	 */
	public SwingArrowVisual() {
		points = new Vector2D[3];
		points[0] = new Vector2D(-6, -4);
		points[1] = new Vector2D(6, 0);
		points[2] = new Vector2D(-6, 4);
	}
	
	/**
	 * Set the rotation angle of the arrow
	 * 
	 * @param angle  New angle
	 */
	public void setAngle(double angle) {
		this.angle  = angle;
	}
	
	/**
	 * Draw the arrow
	 */
	public void draw(Graphics g) {
		int px[] = new int[3];
		int py[] = new int[3];
		
		for (int i=0; i<3; i++) {
			Vector2D p = points[i].copy();
			p.rotate(angle);
			px[i] = (int)(p.getX() + x);
			py[i] = (int)(p.getY() + y);
		}
		
		g.setColor(color);
		g.fillPolygon(px, py, 3);
	}
}
