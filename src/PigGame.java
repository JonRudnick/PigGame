/* name: Jonathan Rudnick
 * date: Nov 4, 2013
 * description: 
 */

import java.util.Scanner;
import java.util.Random;

public class PigGame {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random randBool = new Random();
		String response;
		PigPlayer p1;
		PigPlayer p2;

		System.out.println("First Player, please enter your name. Enter 'Computer' for a computer player.");
		response = keyboard.nextLine();
		if (response.equals("Computer")) {
			p1 = new HoldAtTwentyPlayer();
		}
		else if (response.equals("")) {
			p1 = new PigPlayer();
		}
		else {
			p1 = new PigPlayer(response);
		}
		System.out.println("Second Player, please enter your name. Enter 'Computer' for a computer player.");
		response = keyboard.nextLine();
		if (response.equals("Computer")) {
			p2 = new HoldAtTwentyPlayer();
		}
		else if (response.equals("")) {
			p2 = new PigPlayer();
		}
		else {
			p2 = new PigPlayer(response);
		}

		boolean p1Turn = randBool.nextBoolean();
		boolean stillTurn = true;
		int scoreTotal;

		System.out.println("Welcome to Pig!");
		System.out.println("Pig is a dice game with simple rules:");
		System.out.println("Each turn, a player rolls a die until either a 1 is rolled and the player");
		System.out.println("scores 0 points or the player holds and scores the sum of that turn's rolls.");
		System.out.println("");
		System.out.println("What score do you want to play to?");
		scoreTotal = keyboard.nextInt();

		if (p1Turn == true) {
			System.out.println(p1.getName() + " will play first");
		}
		else {
			System.out.println(p2.getName() + " will play first");
		}

		System.out.println("");

		while (p1.getTotalScore() < scoreTotal && p2.getTotalScore() < scoreTotal) {


			if (p1Turn == true) {
				stillTurn = p1.rollsDie();
			}
			else {
				stillTurn = p2.rollsDie();
			}

			if (p1Turn == true && stillTurn == false) {
				p1Turn = false;
			}
			else if (p1Turn == false && stillTurn == false) {
				p1Turn = true;
			}
		}
		if (p1.getTotalScore() >= scoreTotal) {
			System.out.println("");
			System.out.println(p1.getName() + " wins with " + p1.getTotalScore() + " points!");
			System.out.println(p2.getName() + " had " + p2.getTotalScore() + " points.");
		}
		else if (p2.getTotalScore() >= scoreTotal) {
			System.out.println("");
			System.out.println(p2.getName() + " wins with " + p2.getTotalScore() + " points!");
			System.out.println(p1.getName() + " had " + p1.getTotalScore() + " points.");
		}
	}
}
