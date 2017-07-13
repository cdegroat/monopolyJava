package monopoly.classes;

import monopoly.interfaces.IMonopolyPlayer;

public class MonopolyPlayer implements IMonopolyPlayer {

	String playerName;
	int playerPosition;
	int playerMoney;
	int turnNumber;
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getPlayerPosition() {
		return playerPosition;
	}

	public int getPlayerMoney() {
		return playerMoney;
	}

	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}

	public void setPlayerMoney(int playerMoney) {
		this.playerMoney = playerMoney;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}
	public void incrementTurnNumber(){
		turnNumber ++;
	}

}
