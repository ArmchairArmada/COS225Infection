package cos225.project6.patchcollision;

import cos225.project6.data.MappedDataGrid;
import cos225.project6.math.Vector2D;
import cos225.project6.simulation.ColliderEntityComponent;
import cos225.project6.simulation.CollisionSystem;
import cos225.project6.simulation.Entity;


/**
 * Collision System that uses a grid of patches to check for colliding colliders.
 * 
 * @author Nathan
 *
 */
public class PatchCollisionSystem extends CollisionSystem {
	private MappedDataGrid<Patch> patchGrid;
	
	/**
	 * Constructor for PatchGrid. <br /> <br />
	 * 
	 * The number of patches will be gridSize * gridSize.
	 * The length of one edge of the PatchGrid will be gridSize * patchSize.
	 * 
	 * @param gridSize  Number of patches along one edge of square
	 * @param patchSize  Size of one edge of square patch
	 */
	public PatchCollisionSystem(int gridSize, double patchSize) {
		patchGrid = new MappedDataGrid<Patch>(Patch.class, gridSize, patchSize);
	}
	
	/**
	 * Get the size of one edges of the patch grid used.
	 * 
	 * @return  The size of one edges of the patch grid used.
	 */
	public int getGridSize() {
		return patchGrid.getGridSize();
	}
	
	/**
	 * Get the size of one edge of the square patches
	 * 
	 * @return  The size of one edge of the square patches
	 */
	public double getPatchSize() {
		return patchGrid.getPatchSize();
	}
	
	public Patch getPatchAtPosition(Vector2D position) {
		return getMappedPatch(position.getX(), position.getY());
	}
	
	/**
	 * Get the value of the patch at X, Y in the grid. <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @param x  X coordinate of patch cell in PatchGrid
	 * @param y  Y coordinate of patch cell in PatchGrid
	 * 
	 * @return  Value at the specified patch cell
	 */
	public Patch getPatch(int x, int y) {
		return patchGrid.getDataAt(x, y);
	}
	
	/**
	 * Get the patch at the wrapped mapped position. <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @param x  X coordinate in Turtle space
	 * @param y  Y coordinate in Turtle space
	 * 
	 * @return  The value of the patch at that position
	 */
	public Patch getMappedPatch(double x, double y) {
		return patchGrid.getMappedData(x, y);
	}
	
	/**
	 * Create a default Collider Entity Component for the CollisionSystem implementation.
	 * 
	 * @param entity  Entity that will be using this Collider
	 * @return  New ColliderEntityComponent
	 */
	@Override
	public ColliderEntityComponent createDefaultCollider(Entity entity) {
		return new PatchColliderEntityComponent(entity, this);
	}
	
	/**
	 * Create a default Collider Entity Component for the CollisionSystem implementation. <br /> <br />
	 * 
	 * This creation method provides the option of specifying the size of the
	 * collision shape -- for example, if a CollisionSystem might overlapping
	 * circles or bounding boxes to test collisions.
	 * 
	 * @param entity  Entity that will be using this Collider
	 * @param radius  Size of the collision shape
	 * @return  New ColliderEntityComponent
	 */
	@Override
	public ColliderEntityComponent createDefaultCollider(Entity entity, double radius) {
		// Currently ignores extra arguments
		return new PatchColliderEntityComponent(entity, this);
	}
	
	/**
	 * Create a default Collider Entity Component for the CollisionSystem implementation. <br /> <br />
	 * 
	 * Collision layers can be used to filter out unwanted collisions with
	 * other objects.  The user uses bit masks to specify what layers this
	 * collider will be on and what layers this collider can collide with.
	 * 
	 * @param entity  Entity that will be using this Collider
	 * @param layerFlags  Collision layers this collider is on
	 * @param testFlags  Collision layers that this collider can collide with
	 * @return  New ColliderEntityComponent
	 */
	@Override
	public ColliderEntityComponent createDefaultCollider(Entity entity, int layerFlags, int testFlags) {
		// Currently ignores extra arguments
		return new PatchColliderEntityComponent(entity, this);
	}
	
	/**
	 * Create a default Collider Entity Component for the CollisionSystem implementation. <br /> <br />
	 * 
	 * This creation method provides the option of specifying the size of the
	 * collision shape -- for example, if a CollisionSystem might overlapping
	 * circles or bounding boxes to test collisions. <br /> <br />
	 * 
	 * Collision layers can be used to filter out unwanted collisions with
	 * other objects.  The user uses bit masks to specify what layers this
	 * collider will be on and what layers this collider can collide with.
	 * 
	 * @param entity  Entity that will be using this Collider
	 * @param radius  Size of the collision shape
	 * @param layerFlags  Collision layers this collider is on
	 * @param testFlags  Collision layers that this collider can collide with
	 * @return  New ColliderEntityComponent
	 */
	@Override
	public ColliderEntityComponent createDefaultCollider(Entity entity, double radius, int layerFlags, int testFlags) {
		// Currently ignores extra arguments
		return new PatchColliderEntityComponent(entity, this);
	}
	
	/**
	 * Print out how many colliders are in each patch of the grid
	 */
	public void printColliders() {
		for (int y=0; y<patchGrid.getGridSize(); y++) {
			for (int x=0; x<patchGrid.getGridSize(); x++) {
				Patch patch = getPatch(x,y);
				System.out.format("%02d ", patch.getColliderCount());
			}
			System.out.println();
		}
	}
}
