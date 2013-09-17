package com.fessor.Objects;

public class Score {

	
	private int coins;
	private int goldMedal;
	private int silverMedal;
	private int bronzeMedal;
	
	
	
	
	
	public Score(int coins, int goldMedal, int silverMedal, int bronzeMedal) {
		this.coins = coins;
		this.goldMedal = goldMedal;
		this.silverMedal = silverMedal;
		this.bronzeMedal = bronzeMedal;
	}
	
	
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	public int getGoldMedal() {
		return goldMedal;
	}
	public void setGoldMedal(int goldMedal) {
		this.goldMedal = goldMedal;
	}
	public int getSilverMedal() {
		return silverMedal;
	}
	public void setSilverMedal(int silverMedal) {
		this.silverMedal = silverMedal;
	}
	public int getBronzeMedal() {
		return bronzeMedal;
	}
	public void setBronzeMedal(int bronzeMedal) {
		this.bronzeMedal = bronzeMedal;
	}
	
	
	
}
