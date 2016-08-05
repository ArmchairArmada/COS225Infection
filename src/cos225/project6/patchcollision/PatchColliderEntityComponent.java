package cos225.project6.patchcollision;

import java.util.Iterator;

import cos225.project6.simulation.ColliderEntityComponent;
import cos225.project6.simulation.Entity;


/**
 * Collider Entity Component for the Patch Collision System
 * 
 * @author Nathan
 *
 */
public class PatchColliderEntityComponent extends ColliderEntityComponent {
	PatchCollisionSystem collisionSystem = null;
	Patch currentPatch = null;
	
	/**
	 * Constructor
	 * 
	 * @param entity  Entity this component belongs to
	 */
	public PatchColliderEntityComponent(Entity entity, PatchCollisionSystem collisionSystem) {
		super(entity);
		this.collisionSystem = collisionSystem; //(PatchCollisionSystem) entity.getWorld().getCollisionSystem();
		currentPatch = collisionSystem.getPatchAtPosition(entity.getPosition());
	}
	
	@Override
	public void cleanup() {
		currentPatch.removeCollider(this);
		currentPatch = null;
		collisionSystem = null;
		super.cleanup();
	}
	
	/**
	 * Update the collider to match entities movement
	 */
	@Override
	public void update() {
		Patch oldPatch = currentPatch;
		currentPatch = collisionSystem.getPatchAtPosition(getEntity().getPosition());
		
		if (oldPatch != currentPatch) {
			oldPatch.removeCollider(this);
			currentPatch.addCollider(this);
		}
	}
	
	/**
	 * Simple check to see if this is colliding with anything
	 * 
	 * @return  True if colliding with something
	 */
	@Override
	public boolean isColliding() {
		return currentPatch.isBumping();
	}
	
	/**
	 * Get an arbitrary collider this is colliding with
	 * 
	 * @return  Get arbitrary collider that is being collided with
	 */
	@Override
	public ColliderEntityComponent oneOfCollisions() {
		ColliderEntityComponent collider = currentPatch.getFirstCollider();
		if (collider == this)
		{
			collider = currentPatch.getLastCollider();
			if (collider == this)
				return null;
		}
		return collider;
	}
	
	/**
	 * Get number of colliders this is colliding with
	 * 
	 * @return  Number of colliders in this patch
	 */
	@Override
	public int colliderCount() {
		return currentPatch.getColliderCount();
	}
	
	/**
	 * Get the collider that is at the specified index number. <br /> <br />
	 * 
	 * pre: 0 <= index < colliderCount() <br />
	 * post: 
	 * 
	 * @param index
	 * @return  Collider at the index
	 */
	@Override
	public ColliderEntityComponent getCollisionByIndex(int index) {
		return currentPatch.getColliderByIndex(index);
	}

	/**
	 * Iterate over collisions
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<ColliderEntityComponent> iterator() {
		return (Iterator<ColliderEntityComponent>) currentPatch;
	}
}
