package cos225.project6.simulation;

import java.util.Iterator;


/**
 * Component Entity objects can use for handling collision detection with
 * other entities.
 * 
 * @author Nathan
 *
 */
public class ColliderEntityComponent implements Iterable<ColliderEntityComponent>{
	private Entity entity;
	
	/**
	 * Creates ColliderEntityComponent that will be used by the specified entity
	 * 
	 * @param entity  Entity using this component
	 */
	public ColliderEntityComponent(Entity entity) {
		this.entity = entity;
	}
	
	/**
	 * Cleans up component before it is destroyed
	 */
	public void cleanup() {
		// Override for Implemenations specific cleanup opperation
		// Be sure to run super.cleanup()
		entity = null;
	}
	
	/**
	 * Get the entity associated with this collider component <br /> <br />
	 * 
	 * Pre: <br />
	 * Post:
	 * 
	 * @return  Entity this component belongs to
	 */
	public Entity getEntity() {
		return entity;
	}
	
	/**
	 * Updates the collider, for example can be done after moving an entity. <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: This Collider will be updated and the CollisionSystem may also be
	 */
	public void update() {
		// Override this for implementation specific behavior
	}
	
	/**
	 * Simple check to see if this is colliding with anything
	 * 
	 * @return  True of this Collider is touching another Collider
	 */
	public boolean isColliding() {
		return false;
	}
	
	/**
	 * Get an arbitrary collider this is colliding with
	 * 
	 * @return  Arbitrarily selected Collider this Collider is touching
	 */
	public ColliderEntityComponent oneOfCollisions() {
		return null;
	}
	
	/**
	 * Get number of colliders this is colliding with
	 * 
	 * @return  Number of other Colliders this Collider is touching
	 */
	public int colliderCount() {
		return 0;
	}
	
	/**
	 * Get the collider that is at the specified index number. <br /> <br />
	 * 
	 * pre: 0 <= index < collisionCount() <br />
	 * post: 
	 * 
	 * @param index  Index value of list of Collider Entity Components
	 * @return  The Collider Entity Componenet at that index value
	 */
	public ColliderEntityComponent getCollisionByIndex(int index) {
		return null;
	}

	/**
	 * Iterate over collisions.  Can be used to easily have an entity interact
	 * with all other entities it is be colliding with.
	 */
	@Override
	public Iterator<ColliderEntityComponent> iterator() {
		// Implementation needs to provide suitable iterator
		return null;
	}
}
