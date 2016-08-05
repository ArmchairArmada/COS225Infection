package cos225.project6.infection;

import cos225.project6.data.MutableValue;

/**
 * Keeps track of infection information
 * 
 * @author Nathan
 *
 */
public class InfectionData {
	private int population = 1;
	private int infected = 0;
	MutableValue<Double> infectedPercent = null;
	
	public InfectionData() {
		infectedPercent = new MutableValue<Double>(0.0);
	}
	
	/**
	 * Get the population size
	 * @return  The size of the population
	 */
	public int getPopulation() {
		return population;
	}
	
	/**
	 * Set the population size
	 * 
	 * @param population  New population size
	 */
	public void setPopulation(int population) {
		this.population = population;
		updatePercent();
	}
	
	/**
	 * Get the number of infected
	 * 
	 * @return  Number of infected
	 */
	public int getInfected() {
		return infected;
	}
	
	/**
	 * Set the number of infected
	 * 
	 * @param value  New number of infected
	 */
	public void setInfected(int value) {
		infected = value;
		updatePercent();
	}
	
	/**
	 * Infected percentage that can be used with the line graph
	 * 
	 * @return  Percentage of infected (0 to 1)
	 */
	public MutableValue<Double> getSharedInfectedPercent() {
		return infectedPercent;
	}
	
	/**
	 * Call when Turtle is newly infected
	 */
	public void infect() {
		infected++;
		updatePercent();
	}
	
	/**
	 * Call when Turtle has been healed
	 */
	public void heal() {
		infected--;
		updatePercent();
	}
	
	/**
	 * Update the infected percent
	 */
	private void updatePercent() {
		infectedPercent.setValue((double)infected / (double)population);
	}
}
