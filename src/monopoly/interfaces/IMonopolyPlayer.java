package monopoly.interfaces;

public interface IMonopolyPlayer {
	
	public String getPlayerName();
	public int getPlayerPosition();
	public int getPlayerMoney();
	public int getTurnNumber();
	
	public void setPlayerName(String name);
	public void setPlayerPosition(int position);
	public void setPlayerMoney(int money);
	public void setTurnNumber(int number);
	public void incrementTurnNumber();
	
}
