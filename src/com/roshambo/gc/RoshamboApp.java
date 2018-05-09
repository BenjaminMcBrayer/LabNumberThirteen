//Benjamin McBrayer, 5.8.2018

package com.roshambo.gc;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Human user = new Human();
		int userWins = 0;
		int userLosses = 0;
		int nemesisWins = 0;
		int nemesisLosses = 0;
		String userName;
		String selectNemesis;
		String userRoshamboVal;
		String playAgain;
		Player nemesis = null;
		System.out.println("Welcome to Roshambo!");

		// Prompt user to enter name; greet user.
		userName = Validator.getString(scnr, "Please enter your name: ");
		user.setName(userName);

		do {
			// Prompt user to select an opponent.
			selectNemesis = Validator.getString(scnr, "Would you like to play against The Jets or The Sharks (J/S)? ");
			if (selectNemesis.equalsIgnoreCase("J")) {
				System.out.println("You have chosen to play against The Jets. Good luck!");
				nemesis = new Rock();
				nemesis.setName("The Jets");

				// Display the user's roshamboVal.
				userRoshamboVal = Validator.getString(scnr, "Rock, paper, or scissors? (R/P/S): ");
				if (userRoshamboVal.equalsIgnoreCase("R")) {
					user.setRoshamboValue(Roshambo.ROCK);
					System.out.print(userName + ": " + Roshambo.ROCK + "\n");
				} else if (userRoshamboVal.equalsIgnoreCase("P")) {
					user.setRoshamboValue(Roshambo.PAPER);
					System.out.print(userName + ": " + Roshambo.PAPER + "\n");
				} else if (userRoshamboVal.equalsIgnoreCase("S")) {
					user.setRoshamboValue(Roshambo.SCISSORS);
					System.out.print(userName + ": " + Roshambo.SCISSORS + "\n");
				}

				// Display the opponent's roshamboVal.
				System.out.print(nemesis.getName() + ": ");
				nemesis.generateRoshambo();

			} else if (selectNemesis.equalsIgnoreCase("S")) {
				System.out.println("You have chosen to play against The Sharks. Good luck!");
				nemesis = new Random();
				nemesis.setName("The Sharks");

				// Display the user's roshamboVal.
				userRoshamboVal = Validator.getString(scnr, "Rock, paper, or scissors? (R/P/S): ");
				if (userRoshamboVal.equalsIgnoreCase("R")) {
					user.setRoshamboValue(Roshambo.ROCK);
					System.out.print(userName + ": " + Roshambo.ROCK + "\n");
				} else if (userRoshamboVal.equalsIgnoreCase("P")) {
					user.setRoshamboValue(Roshambo.PAPER);
					System.out.print(userName + ": " + Roshambo.PAPER + "\n");
				} else if (userRoshamboVal.equalsIgnoreCase("S")) {
					user.setRoshamboValue(Roshambo.SCISSORS);
					System.out.print(userName + ": " + Roshambo.SCISSORS + "\n");
				}

				// Display the opponent's roshamboVal.
				System.out.print(nemesis.getName() + ": ");
				nemesis.generateRoshambo();
			}
			// Display the result of the match.
			System.out.println(matchResult(user, nemesis));

			// Display total wins and losses for user and opponent.
			if (matchResult(user, nemesis).contains(nemesis.getName())) {
				++nemesisWins;
				++userLosses;

			} else if (matchResult(user, nemesis).contains(user.getName())) {
				++userWins;
				++userLosses;
			}
			System.out.printf("%1$-10s %2$-10s %3$-10s\n", "", user.getName(), nemesis.getName());
			System.out.printf("%1$-10s %2$-10s %3$-10s\n", "Wins: ", userWins, nemesisWins);
			System.out.printf("%1$-10s %2$-10s %3$-10s\n", "Losses: ", userLosses, nemesisLosses);

			// Prompt user to continue.
			playAgain = Validator.getString(scnr, "Play again? (y/n) ");

		} while (playAgain.equalsIgnoreCase("y"));

		System.out.println("Game Over. Thank you for playing.");

		scnr.close();
	}

	public static String matchResult(Human user, Player nemesis) {
		if (user.getRoshamboValue() == nemesis.getRoshamboValue()) {
			return "It's a draw!";
		} else if ((user.getRoshamboValue() == Roshambo.ROCK && nemesis.getRoshamboValue() == Roshambo.PAPER)
				|| (user.getRoshamboValue() == Roshambo.PAPER && nemesis.getRoshamboValue() == Roshambo.SCISSORS)
				|| (user.getRoshamboValue() == Roshambo.SCISSORS && nemesis.getRoshamboValue() == Roshambo.ROCK)) {
			return nemesis.getName() + " wins!";
		} else {
			return user.getName() + " wins!";
		}
	}

}
