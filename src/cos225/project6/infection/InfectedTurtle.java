package cos225.project6.infection;

import java.awt.Color;

import cos225.project6.math.Rand;
import cos225.project6.simulation.CollisionSystem;
import cos225.project6.simulation.Entity;
import cos225.project6.simulation.ColliderEntityComponent;
import cos225.project6.simview.SwingArrowVisual;
import cos225.project6.simview.SwingWorld;
import cos225.project6.simview.SwingWrappedArrowVisual;
import cos225.project6.turtle.RandomWalk;
import cos225.project6.turtle.Turtle;


/**
 * Turtle that can bump and infect other turtles
 * 
 * @author Nathan
 *
 */
public class InfectedTurtle extends Turtle {
	private RandomWalk randomWalk = null;
	private SwingArrowVisual visual;
	private SwingWorld world;
	private double speed;
	private double turn;
	private InfectionData infectionData;
	private boolean infected = false;
	private CollisionSystem collisionSystem;
	private ColliderEntityComponent collider;
	private double startInfectionChance;
	private double infectionChance;
	private double healTime;
	private double healRand;
	
	private double timeLeftToHeal = 0.0;
	
	/**
	 * Infected Turtle
	 * 
	 * @param world  World the turtle lives in
	 * @param infectionData  Object that keeps track of how many turtles are infected
	 * @param collisionSystem  System for managing collisions between turtles
	 * @param speed  Movement speed
	 * @param turn  Turn randomness
	 * @param startInfectionChance  Probability of starting infected
	 * @param infectionChance  Probability of getting infected if it touches an infected Turtle
	 * @param healTime  Time before healing
	 * @param healRand  Additional random amount of time for healing
	 */
	public InfectedTurtle(SwingWorld world, InfectionData infectionData, CollisionSystem collisionSystem, double speed, double turn, double startInfectionChance, double infectionChance, double healTime, double healRand) {
		super(world.getPopulation());
		this.world = world;
		this.infectionData = infectionData;
		this.collisionSystem = collisionSystem;
		this.speed = speed;
		this.turn = turn;
		this.startInfectionChance = startInfectionChance;
		this.infectionChance = infectionChance;
		this.healTime = healTime;
		this.healRand = healRand;
	}
	
	/**
	 * Create copy of this InfectedTurtle
	 */
	public InfectedTurtle copy() {
		return new InfectedTurtle(world, infectionData, collisionSystem, speed, turn, startInfectionChance, infectionChance, healTime, healRand);
	}
	
	/**
	 * Initialize the entity
	 */
	@Override
	public void init() {
		collider = collisionSystem.createDefaultCollider(this);
		randomWalk = new RandomWalk(this, speed, turn);
		visual = new SwingWrappedArrowVisual(world.getGridSize(), world.getPatchSize());
		world.getVisuals().add(visual);
		
		if (Rand.getRandom().nextDouble() < startInfectionChance)
		{
			infect();
		}
	}
	
	/**
	 * Clean up the entity when it is destroyed.
	 */
	@Override
	public void cleanup() {
		world.getVisuals().remove(visual);
		collider.cleanup();
		super.cleanup();
	}
	
	/**
	 * Receive simple message
	 */
	public void message(String msg) {
		if (msg.equals("infect")) {
			if (!infected && Rand.getRandom().nextDouble() < infectionChance)
				infect();
		}
	}
	
	/**
	 * Infect the turtle
	 */
	public void infect() {
		if (!infected) {
			visual.setColor(Color.RED);
			infectionData.infect();
			infected = true;
			timeLeftToHeal = healTime + Rand.getRandom().nextDouble() * healRand;
		}
	}
	
	/**
	 * Heal from infection
	 */
	public void heal() {
		if (infected) {
			visual.setColor(Color.BLUE);
			infectionData.heal();
			infected = false;
		}
	}
	
	/**
	 * Update the Infected Turtle by having it randomly walk, bump, and infect stuff
	 * 
	 * @param timeDelta  Amount of time that has passed since last update
	 */
	@Override
	public void update(double timeDelta) {
		randomWalk.update(timeDelta);
		collider.update();
		visual.setX(xcor());
		visual.setY(ycor());
		visual.setAngle(angle);
		
		if (infected) {
			for (int i=0; i<collider.colliderCount(); i++) {
				Entity e = collider.getCollisionByIndex(i).getEntity();
				if (e != this)
					e.message("infect");
			}
			
			timeLeftToHeal -= timeDelta;
			if (timeLeftToHeal <= 0)
				heal();
		}
	}
}
