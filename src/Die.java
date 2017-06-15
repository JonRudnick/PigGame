/* name: Jonathan Rudnick
 * date: Oct 31, 2013
 * description: a simple Die class that can represent a die of any number of sides
 */

import java.util.Random;

public class Die { 

	//data field 
	private int numberOfSides; 

	/** 
	 * getNumberOfSides 
	 * accessor method 
	 */ 
	public int getNumberOfSides() { 
		return numberOfSides; 
	}  
	/** 
	 * setNumberOfSides 
	 * mutator method 
	 */ 
	public void setNumberOfSides(int n) { 
		numberOfSides = n; 
	} 

	/** 
	 * nextRoll - return one of the die values at random. Each value is equiprobable. 
	 * @return die value rolled (between 1 and numberOfSides) 
	 */ 
	public int nextRoll() { 
		Random randomNumber = new Random(); 
		return randomNumber.nextInt(numberOfSides) +1; 
	} 

	/** 
	 * Constructor 
	 * @parameter n -- numberOfSides 
	 */ 
	public Die(int n) { 
		numberOfSides = n; 
	} 	 

	/** 
	 * Default Constructor 
	 * sets numberOfSides to 6 
	 */ 
	public Die() { 
		numberOfSides = 6; 
	}
}