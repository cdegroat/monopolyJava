package monopoly.classes;

import monopoly.interfaces.IMonopolyBoard;
import monopoly.interfaces.IMonopolyPlayer;
import monopoly.interfaces.IMonopolySquare;

public class MonopolyBoard implements IMonopolyBoard {

	@Override
	public IMonopolySquare getSquareAt(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void movePlayer(IMonopolyPlayer player, int number) {
		int playerPositionStart = player.getPlayerPosition();
		int playerPositionEnd = (playerPositionStart + number);
		if(playerPositionEnd >= 40){
			player.setPlayerMoney(player.getPlayerMoney() + 200);
			playerPositionEnd = playerPositionEnd % 40;
		}
		player.setPlayerPosition(playerPositionEnd);
		
	}

}
