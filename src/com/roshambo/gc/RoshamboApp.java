
package com.roshambo.gc;

import java.util.Scanner;

/**
 * @author benjamin.mcbrayer
 * @version 3.0
 */
public class RoshamboApp {

	public static void main(String[] args) {
		// Declare and initialize variables.
		Scanner scnr = new Scanner(System.in);
		Player user = new Human();
		int userWins = 0;
		int userLosses = 0;
		int nemesisWins = 0;
		int nemesisLosses = 0;
		Roshambo userValue;
		String userName;
		String selectNemesis;
		String playAgain;
		String result;
		Player nemesis = null;

		// Introduce program.
		System.out.println("Welcome to Roshambo!");

		// Prompt user to enter name; greet user.
		userName = Validator.getString(scnr, "Please enter your name: ");
		user.setName(userName);

		// Prompt user to select an opponent.
		selectNemesis = Validator.getString(scnr, "Would you like to play against The Jets or The Sharks (J/S)? ");
		if (selectNemesis.equalsIgnoreCase("J")) {
			nemesis = playFalseNemesis();

		} else if (selectNemesis.equalsIgnoreCase("S")) {
			nemesis = playTrueNemesis();
		}

		do {
			// Prompt user to play.
			userValue = user.generateRoshambo();
			user.setValue(userValue);

			// Display the opponent's roshamboVal.
			System.out.println(nemesis.getName() + ": " + nemesis.getValue());

			// Display the user's roshamboVal.
			System.out.println(userName + ": " + user.getValue());

			// Display the result of the match.
			result = matchResult(user, nemesis);
			System.out.println(result);

			// Display total wins and losses for user and opponent.
			if (result.contains(nemesis.getName())) {
				++nemesisWins;
				++userLosses;

			} else if (result.contains(user.getName())) {
				++userWins;
				++nemesisLosses;
			}
			displayWinsAndLosses(user, userWins, userLosses, nemesis, nemesisWins, nemesisLosses);

			// Prompt user to continue.
			playAgain = Validator.getString(scnr, "Play again? (y/n) ");

		} while (playAgain.equalsIgnoreCase("y"));

		System.out.println("Game Over. Thank you for playing.");

		scnr.close();
	}

	/**
	 * @return
	 */
	public static Player playTrueNemesis() {
		Player nemesis;
		System.out.println("You have chosen to play against The Sharks. Good luck!");
		nemesis = new TrueNemesis();
		nemesis.setName("The Sharks");
		Roshambo nemesisValue = nemesis.generateRoshambo();
		nemesis.setValue(nemesisValue);
		return nemesis;
	}

	/**
	 * @return
	 */
	public static Player playFalseNemesis() {
		Player nemesis;
		System.out.println("You have chosen to play against The Jets. Good luck!");
		nemesis = new FalseNemesis();
		nemesis.setName("The Jets");
		Roshambo nemesisValue = nemesis.generateRoshambo();
		nemesis.setValue(nemesisValue);
		return nemesis;
	}

	/**
	 * @param user
	 * @param nemesis
	 * @return
	 */
	public static String matchResult(Player user, Player nemesis) {
		if (user.getValue() == nemesis.getValue()) {
			return "It's a draw!";
		} else if ((user.getValue() == Roshambo.ROCK && nemesis.getValue() == Roshambo.PAPER)
				|| (user.getValue() == Roshambo.PAPER && nemesis.getValue() == Roshambo.SCISSORS)
				|| (user.getValue() == Roshambo.SCISSORS && nemesis.getValue() == Roshambo.ROCK)) {
			return nemesis.getName() + " wins!";
		} else {
			return user.getName() + " wins!";
		}
	}

	/**
	 * @param user
	 * @param userWins
	 * @param userLosses
	 * @param nemesis
	 * @param nemesisWins
	 * @param nemesisLosses
	 */
	public static void displayWinsAndLosses(Player user, int userWins, int userLosses, Player nemesis, int nemesisWins,
			int nemesisLosses) {
		System.out.printf("%1$-10s %2$-10s %3$-10s\n", "", user.getName(), nemesis.getName());
		System.out.printf("%1$-10s %2$-10s %3$-10s\n", "Wins: ", userWins, nemesisWins);
		System.out.printf("%1$-10s %2$-10s %3$-10s\n", "Losses: ", userLosses, nemesisLosses);
	}
}
