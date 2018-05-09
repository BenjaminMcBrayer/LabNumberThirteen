package com.roshambo.gc;

public abstract class Player {
	private String name;
	private Roshambo roshamboValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roshambo getRoshamboValue() {
		return roshamboValue;
	}

	public void setRoshamboValue(Roshambo roshamboValue) {
		this.roshamboValue = roshamboValue;
	}

	public abstract void generateRoshambo();

	@Override
	public String toString() {
		return "Player [name=" + name + ", roshamboValue=" + roshamboValue + "]";
	}
}
