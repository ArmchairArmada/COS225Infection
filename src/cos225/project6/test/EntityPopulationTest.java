package cos225.project6.test;

import org.junit.Test;

import cos225.project6.math.Rand;
import cos225.project6.simulation.Entity;
import cos225.project6.simulation.EntityPopulation;


public class EntityPopulationTest {
	class TestEntity extends Entity {
		public TestEntity(EntityPopulation population) {
			super(population);
		}

		private int counter = Rand.getRandom().nextInt(9)+1;
		
		@Override
		public void update(double timeDelta) {
			counter--;
			System.out.println("Time to live: " + counter);
			if (counter == 0) {
				System.out.println("Time to die.");
				kill();
			}
		}
	}
	
	@Test
	public void testUpdate() {
		EntityPopulation ep = new EntityPopulation();
		
		for (int i=0; i<5; i++) {
			ep.add(new TestEntity(ep));
		}
		
		while (ep.getTotalCount() > 0) {
			ep.update(0);
			System.out.println("-----");
		}
	}
}
