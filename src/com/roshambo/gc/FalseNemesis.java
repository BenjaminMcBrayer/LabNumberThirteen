package com.roshambo.gc;

/**
 * @author benjamin.mcbrayer
 *
 */
public class FalseNemesis extends Player {

	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}
}
