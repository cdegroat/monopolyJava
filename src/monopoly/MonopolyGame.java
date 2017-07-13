package monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import monopoly.interfaces.IMonopolyBoard;
import monopoly.interfaces.IMonopolyPlayer;
import monopoly.interfaces.IRoundPlayer;
import monopoly.interfaces.ITurnTaker;

public class MonopolyGame {

	private IMonopolyBoard board;
	private ArrayList<IMonopolyPlayer> players = new ArrayList<IMonopolyPlayer>();
	IRoundPlayer roundPlayer;
	ITurnTaker turnTaker;
	Random rand = new Random();
	int rounds = 0;
	boolean gameStarted = false;
	
	public void playRound(){
		rounds++;
		roundPlayer.playRound(players, turnTaker,board);
	}

	public IMonopolyBoard getBoard() {
		return board;
	}
	public void setBoard(IMonopolyBoard board) {
		this.board = board;
	}
	public ArrayList<IMonopolyPlayer> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<IMonopolyPlayer> players) {
		this.players = players;
	}
	
	public void addPlayer(IMonopolyPlayer player){
		if(players.size() == 8){
			throw new RuntimeException("Too many players added, a maximum of 8 players can play.");
		}
		players.add(player);
	}
	
	public void startGame(){
		gameStarted = true;
		if(players.size() < 2 || players.size() > 8){
			throw new RuntimeException("Incorrect number of players, require between 2 and 8 players to play."); 
		}
	}
	
	public void randomizePlayerOrders(){
		if(players.size() == 0){
			throw new RuntimeException("No Players to shuffle.");
		}
		Collections.shuffle(players, rand);
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public IRoundPlayer getRoundPlayer() {
		return roundPlayer;
	}

	public void setRoundPlayer(IRoundPlayer roundPlayer) {
		this.roundPlayer = roundPlayer;
	}

	public ITurnTaker getTurnTaker() {
		return turnTaker;
	}

	public void setTurnTaker(ITurnTaker turnTaker) {
		this.turnTaker = turnTaker;
	}
	
}
