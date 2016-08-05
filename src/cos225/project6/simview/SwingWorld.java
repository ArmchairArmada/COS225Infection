package cos225.project6.simview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

import cos225.project6.patchcollision.PatchCollisionSystem;
import cos225.project6.simulation.EntityPopulation;
import cos225.project6.simulation.ProtoCopier;

/**
 * This handles a lot of things.  It is a JPanel for displaying the simulation
 * world.  It also keeps track of the population, visuals, collision system,
 * copying prototypes, and a few other things that migth be useful for
 * entities to use. 
 * 
 * @author Nathan
 *
 */
public class SwingWorld extends JPanel {
	private static final long serialVersionUID = 1L;
	private SwingVisualsCollection visuals;
	private Timer timer;
	private PatchCollisionSystem collisionSystem;
	private EntityPopulation population;
	private double timeDelta;
	private ProtoCopier protoCopier;
	private int gridSize;
	private int patchSize;

	/**
	 * Constructor
	 * 
	 * @param gridSize  Number of patches along one side of square collision grid
	 * @param patchSize  Size of the pages used by the collision grid
	 * @param updateRate  Update frequency in milliseconds
	 */
	public SwingWorld(int gridSize, int patchSize, int updateRate) {
		this.gridSize = gridSize;
		this.patchSize = patchSize;
		
		setPreferredSize(new Dimension(gridSize * patchSize, gridSize * patchSize));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		collisionSystem = new PatchCollisionSystem(gridSize, patchSize);
		population = new EntityPopulation();
		visuals = new SwingVisualsCollection();
		protoCopier = new ProtoCopier();
		
		timeDelta = updateRate / 1000.0;
		
		ActionListener refresh = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				population.update(timeDelta);
				repaint();
			}
		};
		
		timer = new Timer(updateRate, refresh);
	}
	
	/**
	 * Get the visuals component
	 * 
	 * @return  Object that manages drawing visuals to the panel
	 */
	public SwingVisualsCollection getVisuals() {
		return visuals;
	}
	
	/**
	 * Get the population component
	 * 
	 * @return  Object that manages entity population life time and activity 
	 */
	public EntityPopulation getPopulation() {
		return population;
	}
	
	/**
	 * Get the prototype copier
	 * 
	 * @return  Object that copies prototype versions of objects
	 */
	public ProtoCopier getProtoCopier() {
		return protoCopier;
	}
	
	/**
	 * Get the collision system
	 * 
	 * @return  Object that is used for managing collisions
	 */
	public PatchCollisionSystem getCollisionSystem() {
		return collisionSystem;
	}
	
	/**
	 * Draw the world
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(0.91f, 0.91f, 0.91f));
		for (int y=0; y<collisionSystem.getGridSize(); y++) {
			for (int x=0; x<collisionSystem.getGridSize(); x++) {
				if (collisionSystem.getPatch(x, y).getColliderCount() > 0) {
					int bx = (int)(x * collisionSystem.getPatchSize());
					int by = (int)(y * collisionSystem.getPatchSize());
					int bw = (int)(collisionSystem.getPatchSize());
					int bh = (int)(collisionSystem.getPatchSize());
					g.fillRect(bx, by, bw, bh);
				}
			}
		}
		
		visuals.draw(g);
	}
	
	/**
	 * Start updating the world
	 */
	public void start() {
		timer.start();
	}
	
	/**
	 * Stop updating the world
	 */
	public void stop() {
		timer.stop();
	}
	
	/**
	 * Reset the world (clears visuals, collision, and population)
	 */
	public void reset() {
		timer.stop();
		visuals = new SwingVisualsCollection();
		collisionSystem = new PatchCollisionSystem(gridSize, patchSize);
		population.clear();
		repaint();
	}

	/**
	 * Get the grid size
	 * 
	 * @return  Size of collision grid
	 */
	public int getGridSize() {
		return gridSize;
	}
	
	/**
	 * Get the size of the collision patches
	 * 
	 * @return  Size of the collision patch
	 */
	public int getPatchSize() {
		return patchSize;
	}
}
