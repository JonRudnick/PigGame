import java.util.Scanner;

/* name: Jonathan Rudnick
 * date: Nov 6, 2013
 * description: A computer class that holds at a turn total of 20
 */

public class HoldAtTwentyPlayer extends PigPlayer {

	public HoldAtTwentyPlayer() {
		name = "Computer";
		turnTotal = 0;
		totalScore = 0;	
	}

	public boolean rollsDie() {
		boolean result = true; //is it still turn
		Die myDie = new Die();
		int roll;

		System.out.println("It's " + name + "'s turn. Current total score: " + totalScore);
		System.out.println("press return to roll. press any key to hold");
		if (turnTotal < 20) {
			System.out.println();
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
			System.out.println("Hold");
			//hold
			totalScore += turnTotal;
			result = false;
			turnTotal = 0;
			System.out.println("HELD! total score is " + totalScore);
		}

		return result;
	}

}
