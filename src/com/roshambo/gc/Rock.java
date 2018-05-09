//Benjamin McBrayer, 5.8.2018

package com.roshambo.gc;

public class Rock extends Player {

	public Rock() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ROCK";
	}

	@Override
	public void generateRoshambo() {
		setRoshamboValue(Roshambo.ROCK);
		System.out.println(Roshambo.ROCK);
	}
}
