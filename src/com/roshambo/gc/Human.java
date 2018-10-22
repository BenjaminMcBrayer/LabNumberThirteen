package com.roshambo.gc;

import java.util.Scanner;

/**
 * @author benjamin.mcbrayer
 *
 */
public class Human extends Player {

	private static Scanner scnr;

	/* (non-Javadoc)
	 * @see com.roshambo.gc.Player#generateRoshambo()
	 */
	@Override
	public Roshambo generateRoshambo() {
		scnr = new Scanner(System.in);
		String userInput = Validator.getString(scnr, "Rock, paper, or scissors? (R/P/S): ");
		
		switch (userInput) {
		case "R":
		case "r":
			return Roshambo.ROCK;
			
		case "P":
		case "p":
			return Roshambo.PAPER;
			
		case "S":
		case "s":
			return Roshambo.SCISSORS;
			
		default:
			return null;
		}
	}
}
