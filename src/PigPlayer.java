/* name: Jonathan Rudnick
 * date: Nov 4, 2013
 * description: 
 */

import java.util.Scanner;

public class PigPlayer {

	protected String name;
	protected int turnTotal;
	protected int totalScore;

	public PigPlayer() {
		name = "Player";
		turnTotal = 0;
		totalScore = 0;		
	}

	public PigPlayer(String n) {
		name = n;
		turnTotal = 0;
		totalScore = 0;
	}

	public String getName() {
		return name;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public int getTurnTotal() {
		return turnTotal;
	}

	public void setName(String n) {
		name = n;
	}

	public boolean rollsDie() {
		boolean result = true; //is it still turn
		Die myDie = new Die();
		int roll;

		System.out.println("It's " + name + "'s turn. Current total score: " + totalScore);
		System.out.println("press return to roll. press any key to hold");

		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		if (input.length() == 0) {
			//rolling the die
			roll = myDie.nextRoll();
			System.out.println("You rolled a " + roll);
			if (roll == 1) {
				result = false;
				turnTotal = 0;
				System.out.println("BUSTED! " + name + "'s total score is " + totalScore);
			}
			else {
				turnTotal += roll;
				System.out.println(name + "'s turn total is: " + turnTotal);
			}

		}
		else {
			//hold
			totalScore += turnTotal;
			result = false;
			turnTotal = 0;
			System.out.println("HELD! " + name + "'s total score is " + totalScore);
		}

		return result;
	}

}