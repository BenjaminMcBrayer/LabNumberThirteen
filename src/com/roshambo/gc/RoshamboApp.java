package com.roshambo.gc;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Human user = new Human();
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
