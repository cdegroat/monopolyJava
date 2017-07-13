package monopoly.interfaces;

public interface IMonopolyBoard {

	public IMonopolySquare getSquareAt(int position);
	
	public void movePlayer(IMonopolyPlayer player, int number);
}
