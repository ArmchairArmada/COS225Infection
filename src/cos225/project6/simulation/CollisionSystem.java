package cos225.project6.simulation;


/**
 * Base class for a collision system.  This may later be given more functionality.
 * 
 * @author Nathan
 *
 */
public class CollisionSystem {
	/**
	 * Create a default Collider Entity Component for the CollisionSystem implementation.
	 * 
	 * @param entity  Entity that will be using this Collider
	 * @return  New ColliderEntityComponent
	 */
	public ColliderEntityComponent createDefaultCollider(Entity entity) {
		return null;
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
	public ColliderEntityComponent createDefaultCollider(Entity entity, double radius) {
		return null;
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
	public ColliderEntityComponent createDefaultCollider(Entity entity, int layerFlags, int testFlags) {
		return null;
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
	public ColliderEntityComponent createDefaultCollider(Entity entity, double radius, int layerFlags, int testFlags) {
		return null;
	}
}
