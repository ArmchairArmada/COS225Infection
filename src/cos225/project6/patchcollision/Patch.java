package cos225.project6.patchcollision;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Collision patch that keeps track of number of colliding objects inside 
 * a square region.
 * 
 * @author Nathan
 *
 */
public class Patch implements Iterable<PatchColliderEntityComponent> {
	List<PatchColliderEntityComponent> colliderList;
	
	/**
	 * Constructor
	 */
	public Patch() {
		colliderList = new ArrayList<PatchColliderEntityComponent>();
	}

	/**
	 * Get the number of colliders currently in this patch
	 * 
	 * @return  Number of colliders in the patch
	 */
	public int getColliderCount() {
		return colliderList.size();
	}
	
	/**
	 * Removes a collider from this patch. <br /> <br />
	 * 
	 * Pre: Collider is currently in this patch <br />
	 * Post: Collider has been removed from the patch.
	 * 
	 * @param collider  Collider to remove
	 */
	public void removeCollider(PatchColliderEntityComponent collider) {
		colliderList.remove(collider);
	}
	
	/**
	 * Adds a collider to the patch. <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: Patch now has this collider in it.
	 * 
	 * @param collider
	 */
	public void addCollider(PatchColliderEntityComponent collider) {
		colliderList.add(collider);
	}
	
	/**
	 * Gets the first collider in the list of colliders
	 * 
	 * @return  The first collider in the list
	 */
	public PatchColliderEntityComponent getFirstCollider() {
		if (colliderList.size() > 0)
			return colliderList.get(0);
		return null;
	}
	
	/**
	 * Gets the last collider in the list of colliders.
	 * 
	 * @return  The last collider in the list
	 */
	public PatchColliderEntityComponent getLastCollider() {
		if (colliderList.size() > 0)
			return colliderList.get(colliderList.size()-1);
		return null;
	}
	
	/**
	 * Get a collider by its index position in the list
	 * 
	 * Pre: 0 <= index < this.getColliderCount()
	 * Post:
	 * 
	 * @param index  Index position in the list
	 * @return  A collider at that index
	 */
	public PatchColliderEntityComponent getColliderByIndex(int index) {
		return colliderList.get(index);
	}
	
	/**
	 * Simple check to see if this collider is bumping something.
	 * 
	 * @return  True if bumping another collider
	 */
	public boolean isBumping() {
		return colliderList.size() > 1;
	}
	
	/**
	 * Allows for iterating over colliders in the patch
	 */
	@Override
	public Iterator<PatchColliderEntityComponent> iterator() {
		return colliderList.iterator();
	}
}
