//Benjamin McBrayer, 5.8.2018

package com.roshambo.gc;

public class Random extends Player {
	
	//TODO: Change generateRoshambo so that it returns a value (so that it is not void).
	@Override
	public void generateRoshambo() {
		int random = (int) (Math.random() * 3 + 1);

		switch (random) {

		case 1:
			setRoshamboValue(Roshambo.ROCK);
			System.out.println(Roshambo.ROCK);

			break;

		case 2:
			setRoshamboValue(Roshambo.PAPER);
			System.out.println(Roshambo.PAPER);

			break;

		case 3:
			setRoshamboValue(Roshambo.SCISSORS);
			System.out.println(Roshambo.SCISSORS);

			break;

		}
	}

	@Override
	public String toString() {
		if (getRoshamboValue() == Roshambo.ROCK) {
			return "ROCK";
		}
		if (getRoshamboValue() == Roshambo.PAPER) {
			return "PAPER";
		}
		if (getRoshamboValue() == Roshambo.SCISSORS) {
			return "SCISSORS";
		}
	return null;
	}
}