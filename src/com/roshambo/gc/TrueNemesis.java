package com.roshambo.gc;

/**
 * @author benjamin.mcbrayer
 *
 */
public class TrueNemesis extends Player {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.roshambo.gc.Player#generateRoshambo()
	 */
	@Override
	public Roshambo generateRoshambo() {
		int random = (int) (Math.random() * 3);

		switch (random) {

		case 0:
			return Roshambo.ROCK;

		case 1:
			return Roshambo.PAPER;

		case 2:
			return Roshambo.SCISSORS;

		default:
			return null;
		}
	}
}