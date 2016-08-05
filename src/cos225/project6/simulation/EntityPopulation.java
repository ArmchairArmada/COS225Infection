package cos225.project6.simulation;

import java.util.ArrayList;
import java.util.List;


/**
 * Manages population of Entities in the simulated world.
 * 
 * @author Nathan
 *
 */
public class EntityPopulation {
	private List<Entity> entitiesList = null;
	private List<Entity> deadEntities = null;
	private List<Entity> newEntities = null;
	
	/**
	 * Constructor
	 */
	public EntityPopulation() {
		entitiesList = new ArrayList<Entity>();
		deadEntities = new ArrayList<Entity>();
		newEntities = new ArrayList<Entity>();
	}
	
	/**
	 * Returns the current total number of living entities, taking into
	 * consideration new entities being born and old entities dying off.
	 * 
	 * @return  Current total number of alive entities
	 */
	public int getTotalCount() {
		return entitiesList.size() + newEntities.size() - deadEntities.size();
	}
	
	/**
	 * Get the current number of living and active entities.  This will not
	 * include entities that have just been added and it will not subtract
	 * entities that are going to be removed.
	 * 
	 * @return  Number of currently active entities
	 */
	public int getLivingCount() {
		return entitiesList.size();
	}
	
	/**
	 * Add an entity to the population of entities.
	 * Does not take immediate effect, but instead waits for the next update
	 * before adding entities. <br /> <br />
	 * 
	 * pre: Entity not already in the population <br />
	 * post: Entity now in list of entities
	 * 
	 * @param entity  Entity to add
	 */
	public void add(Entity entity) {
		newEntities.add(entity);
	}
	
	/**
	 * Removes entities from the population.
	 * Does not take immediate effect, but instead waits for the next update
	 * before removing entities. <br /> <br />
	 * 
	 * pre: Entity is currently in the population <br />
	 * post: Entity is no longer in the population
	 * 
	 * @param entity  Entity to remove
	 */
	public void remove(Entity entity) {
		deadEntities.add(entity);
	}
	
	/**
	 * Returns the entity at an index value in the population list
	 * 
	 * @param index  Index of the entity in the population.
	 * @return  The entity at that index location in the population
	 */
	public Entity getEntityByIndex(int index) {
		return entitiesList.get(index);
	}
	
	/**
	 * Removes entities from the active entities list that are no longer alive. <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: All dead entities will be removed from active entities list
	 */
	private void removeDeadEntities() {
		if (deadEntities.size() > 0) {
			for (Entity entity: deadEntities) {
				entitiesList.remove(entity);
			}
			deadEntities.clear();
		}
	}
	
	/**
	 * Add entities to the active entities list <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: All new entities will be added to the active entities list
	 */
	private void addNewEntities() {
		if (newEntities.size() > 0) {
			for (Entity entity: newEntities) {
				entity.init();
				entitiesList.add(entity);
			}
			newEntities.clear();
		}
	}
	
	/**
	 * Update the entities in the population <br /> <br />
	 * 
	 * Pre: <br />
	 * Post: Dead entities will be removed, New entities will be added, and
	 * Entities will be updated
	 * 
	 * @param timeDelta  Amount of time passed since last update
	 */
	public void update(double timeDelta) {
		removeDeadEntities();
		addNewEntities();
		
		for (Entity entity: entitiesList) {
			entity.update(timeDelta);
		}
	}

	public void clear() {
		// TODO Auto-generated method stub
		for (Entity entity: entitiesList) {
			entity.kill();
		}
		entitiesList = new ArrayList<Entity>();
		deadEntities = new ArrayList<Entity>();
		newEntities = new ArrayList<Entity>();
	}
}
