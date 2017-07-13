package monopoly.interfaces;

import java.util.ArrayList;

public interface IRoundPlayer {

	public void playRound(ArrayList<IMonopolyPlayer> players, ITurnTaker turnTaker,IMonopolyBoard board);
}
