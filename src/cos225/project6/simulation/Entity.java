package cos225.project6.simulation;

import cos225.project6.math.Vector2D;


/**
 * The simulation represents all of the moving object as Entities.  The user
 * can extend this Entity class to create custom entity types with unique
 * behaviors.
 * 
 * @author Nathan
 *
 */
public class Entity implements Copyable {
	//protected World world = null;
	protected EntityPopulation population = null;
	protected Vector2D position = null;
	protected double angle = 0.0;
	protected boolean isAlive = true;
	
	/**
	 * Create new entity that will live inside the specified simulation world.
	 * 
	 * @param world  World object this entity lives in
	 */
	public Entity(EntityPopulation population) {
		//this.world = world;
		this.population = population;
		position = new Vector2D();
	}
	
	/**
	 * Copy constructor for copying an entity
	 * 
	 * @param entity
	 */
	public Entity(Entity entity) {
		//this.world = entity.world;
		this.population = entity.population;
		this.isAlive = entity.isAlive;
		position = entity.position.copy();
		angle = entity.angle;
	}
	
	/**
	 * Copy this entity
	 * 
	 * @return  A copy of this entity
	 */
	public Entity copy() {
		return new Entity(this);
	}
	
	public void init() {
	}
	
	/**
	 * Override for entity cleanup.
	 * Be sure to run super.cleanup();
	 */
	public void cleanup() {
		//world = null;
		//population = null;
		//position = null;
	}
	
	public void kill() {
		//if (world != null)
		//	world.removeEntity(this);
		population.remove(this);
		isAlive = false;
		cleanup();
	}
	
	/**
	 * Get the current position of the entity
	 * 
	 * @return  Current position of the entity
	 */
	public Vector2D getPosition() {
		return position;
	}
	
	/**
	 * Get the current rotation angle of the entity
	 * 
	 * @return  Current angle of the entity
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * Get if the entity is alive or not.  Dead entities will be removed
	 * from the simulation.
	 * 
	 * @return  True if entity is alive and False if entity is dead.
	 */
	public boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * Update the entity
	 * 
	 * @param timeDelta  The amount of time that has passed between updates
	 */
	public void update(double timeDelta) {
		// Override for user specified entity behavior
	}
	
	/**
	 * String representation of the Entity
	 */
	public String toString() {
		return "Entity(position="+position+", angle="+angle+")";
	}

	public void message(String msg) {
		// TODO Auto-generated method stub
		
	}
}
