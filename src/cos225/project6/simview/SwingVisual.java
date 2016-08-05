package cos225.project6.simview;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Base class for visual that can be drawn onto a JPanel 
 * 
 * @author Nathan
 *
 */
public class SwingVisual {
	protected int x = 0;
	protected int y = 0;
	protected Color color = Color.BLUE;
	
	/**
	 * Constructor
	 */
	public SwingVisual() {
	}
	
	/**
	 * Constructor with coordinates
	 * 
	 * @param x  x
	 * @param y  y
	 */
	public SwingVisual(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor with coordinates and color
	 * 
	 * @param x  x
	 * @param y  y
	 * @param color  color
	 */
	public SwingVisual(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	/**
	 * Set the x coordinate
	 * 
	 * @param x x
	 */
	public void setX(double x) {
		this.x = (int) x;
	}

	/**
	 * Set the y coordinate
	 * 
	 * @param y y
	 */
	public void setY(double y) {
		this.y = (int) y;
	}

	/**
	 * Get the x coordinate
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Get the y coordinate
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Get the color of the visual
	 * 
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Set the color
	 * 
	 * @param color  New color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Set the position
	 * 
	 * @param newX x
	 * @param newY y
	 */
	public void setPosition(double newX, double newY) {
		x = (int) newX;
		y = (int) newY;
	}
	
	/**
	 * Draw the visual (a dot)
	 * 
	 * Override for drawing other shapes
	 * 
	 * @param g  Graphics object to draw with
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x-4, y-4, 9, 9);
	}
}
