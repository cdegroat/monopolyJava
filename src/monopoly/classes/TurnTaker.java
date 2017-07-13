package monopoly.classes;

import java.util.ArrayList;

import monopoly.interfaces.IDiceRoller;
import monopoly.interfaces.IMonopolyBoard;
import monopoly.interfaces.IMonopolyPlayer;
import monopoly.interfaces.ITurnTaker;

public class TurnTaker implements ITurnTaker {

	IDiceRoller roller = null;
	
	public TurnTaker(IDiceRoller roller){
		this.roller = roller;
	}
	@Override
	public void takeTurn(IMonopolyPlayer player,IMonopolyBoard board) {
		player.incrementTurnNumber();
		DiceResult res = roller.rollDice();
		board.movePlayer(player, res.numberOne+res.numberTwo);
	}
	public IDiceRoller getRoller() {
		return roller;
	}
	public void setRoller(IDiceRoller roller) {
		this.roller = roller;
	}

}
