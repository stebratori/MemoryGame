package com.fessor.Objects;

public class Player {

	
	private String name = "Fessor";
	private Score score;
	
	
	
	public Player(String name, Score score) {
		
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
