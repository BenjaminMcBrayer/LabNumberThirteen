package com.roshambo.gc;

/**
 * @author benjamin.mcbrayer
 *
 */
public abstract class Player {
	private String name;
	private Roshambo value;
	
	public abstract Roshambo generateRoshambo();

	public Player() {
	}

	public Player(String name, Roshambo value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roshambo getValue() {
		return value;
	}

	public void setValue(Roshambo value) {
		this.value = value;
	}
}
