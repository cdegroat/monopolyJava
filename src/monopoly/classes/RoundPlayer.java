package monopoly.classes;

import java.util.ArrayList;

import monopoly.interfaces.IMonopolyBoard;
import monopoly.interfaces.IMonopolyPlayer;
import monopoly.interfaces.IRoundPlayer;
import monopoly.interfaces.ITurnTaker;

public class RoundPlayer implements IRoundPlayer {

	@Override
	public void playRound(ArrayList<IMonopolyPlayer> players, ITurnTaker turnTaker,IMonopolyBoard board) {
		for(IMonopolyPlayer player:players){
			turnTaker.takeTurn(player,board);
		}
	}

}
