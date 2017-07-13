package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import monopoly.MonopolyGame;
import monopoly.classes.DiceResult;
import monopoly.classes.DiceRoller;
import monopoly.classes.FakeDiceRoller;
import monopoly.classes.MonopolyBoard;
import monopoly.classes.MonopolyPlayer;
import monopoly.classes.RoundPlayer;
import monopoly.classes.TurnTaker;
import monopoly.interfaces.IMonopolyPlayer;

public class PlayerTest {
	
	
	@Test
	public void playerMove7From0() {
		MonopolyGame game = new MonopolyGame();
		game.setBoard(new MonopolyBoard());
		IMonopolyPlayer player = new MonopolyPlayer();
		player.setPlayerName("Horse");
		game.addPlayer(player);
		TurnTaker taker = new TurnTaker(new DiceRoller());
		taker.setRoller(new FakeDiceRoller(3,4));
		game.setTurnTaker(taker);
		game.setRoundPlayer(new RoundPlayer());
		game.playRound();
		Assert.assertEquals(7,player.getPlayerPosition());
		//Player on beginning location (numbered 0), rolls 7, ends up on location 7
	}
	
	@Test
	public void playerMove6from39(){
		//Player on location numbered 39, rolls 6, ends up on location 5
		MonopolyGame game = new MonopolyGame();
		game.setBoard(new MonopolyBoard());
		IMonopolyPlayer player = new MonopolyPlayer();
		player.setPlayerName("Horse");
		player.setPlayerPosition(39);
		game.addPlayer(player);
		TurnTaker taker = new TurnTaker(new DiceRoller());
		taker.setRoller(new FakeDiceRoller(2,4));
		game.setTurnTaker(taker);
		game.setRoundPlayer(new RoundPlayer());
		game.playRound();
		Assert.assertEquals(5,player.getPlayerPosition());
	}
	@Test
	public void playerLandsGoColletsMoney(){
		//During a turn a Player lands on Go and their balance increases by $200.
		MonopolyGame game = new MonopolyGame();
		game.setBoard(new MonopolyBoard());
		IMonopolyPlayer player = new MonopolyPlayer();
		player.setPlayerName("Horse");
		player.setPlayerPosition(38);
		game.addPlayer(player);
		TurnTaker taker = new TurnTaker(new DiceRoller());
		int playerMoney = player.getPlayerMoney();
		taker.setRoller(new FakeDiceRoller(1,1));
		game.setTurnTaker(taker);
		game.setRoundPlayer(new RoundPlayer());
		game.playRound();
		Assert.assertEquals(playerMoney+200, player.getPlayerMoney());
	}
	
	@Test
	public void playerDoesntLandOnGoCollectsNothing(){
		//During a turn a Player lands on some "normal" location and their balance does not change.
		MonopolyGame game = new MonopolyGame();
		game.setBoard(new MonopolyBoard());
		IMonopolyPlayer player = new MonopolyPlayer();
		player.setPlayerName("Horse");
		player.setPlayerPosition(10);
		game.addPlayer(player);
		TurnTaker taker = new TurnTaker(new DiceRoller());
		taker.setRoller(new FakeDiceRoller(5,4));
		int playerMoney = player.getPlayerMoney();
		game.setTurnTaker(taker);
		game.setRoundPlayer(new RoundPlayer());
		game.playRound();
		Assert.assertEquals(playerMoney, player.getPlayerMoney());
	}
	
	@Test
	public void playerPassesGoCollectsMoney(){
		//Player starts before Go near the end of the Board, rolls enough to pass Go. The Player's balance increases by $200.
		MonopolyGame game = new MonopolyGame();
		game.setBoard(new MonopolyBoard());
		IMonopolyPlayer player = new MonopolyPlayer();
		player.setPlayerName("Horse");
		player.setPlayerPosition(38);
		game.addPlayer(player);
		TurnTaker taker = new TurnTaker(new DiceRoller());
		int playerMoney = player.getPlayerMoney();
		taker.setRoller(new FakeDiceRoller(5,4));
		game.setTurnTaker(taker);
		game.setRoundPlayer(new RoundPlayer());
		game.playRound();
		Assert.assertEquals(playerMoney+200, player.getPlayerMoney());
	}
	@Test
	public void playerStartsOnGoDoesNotPassGoTwiceCollectsNothing(){
		//Player starts on Go, takes a turn where the Player does not additionally land on or pass over Go. Their balance remains unchanged.
		MonopolyGame game = new MonopolyGame();
		game.setBoard(new MonopolyBoard());
		IMonopolyPlayer player = new MonopolyPlayer();
		player.setPlayerName("Horse");
		player.setPlayerPosition(0);
		game.addPlayer(player);
		TurnTaker taker = new TurnTaker(new DiceRoller());
		int playerMoney = player.getPlayerMoney();
		taker.setRoller(new FakeDiceRoller(3,4));
		game.setTurnTaker(taker);
		game.setRoundPlayer(new RoundPlayer());
		game.playRound();
		Assert.assertEquals(playerMoney, player.getPlayerMoney());
		
	}
	@Test
	public void playerPassesGoTwiceOnTurnCollects400(){
		//Player passes go twice during a turn. Their balance increases by $200 each time for a total change of $400.
		MonopolyGame game = new MonopolyGame();
		game.setBoard(new MonopolyBoard());
		IMonopolyPlayer player = new MonopolyPlayer();
		player.setPlayerName("Horse");
		player.setPlayerPosition(38);
		game.addPlayer(player);
		TurnTaker taker = new TurnTaker(new DiceRoller());
		int playerMoney = player.getPlayerMoney();
		taker.setRoller(new FakeDiceRoller(1,1));
		game.setTurnTaker(taker);
		game.setRoundPlayer(new RoundPlayer());
		game.playRound();
		Assert.assertEquals(playerMoney+200, player.getPlayerMoney());
		
	}
	@Test
	public void playerStartsBeforeJailLandsOnJailEndsUpOnJustVisiting(){
		//Player starts before Go To Jail, lands on Go To Jail, ends up on Just Visiting and their balance is unchanged.
		
	}
	@Test
	public void playerStartsBeforeJailPassesOverJail(){
		//Player starts before Go To Jail, rolls enough to pass over Go To Jail but not enough to land on or pass over go. Their balance is unchanged and they end up where the should based on what they rolled.
		
	}
	
	
	public void playerLandsOnIncomeTaxWith1800(){
		//During a turn, a Player with an initial total worth of $1800 lands on Income Tax. The balance decreases by $180.
		
	}
	
	public void playerLandsOnIncomeTaxWith2200(){
		//During a turn, a Player with an initial total worth of $2200 lands on Income Tax. The balance decreases by $200.
		
		
	}
	public void playerLandsOnIncomeTaxWith0(){
		//During a turn, a Player with an initial total worth of $0 lands on Income Tax. The balance decreases by $0.
		
	}
	public void playerLandsOnIncomeTaxWith2000(){
		//During a turn, a Player with an initial total worth of $2000 lands on Income Tax. The balance decreases by $200.
		
	}
	public void playerDoesNotLandOnIncomeTax(){
		//During a turn, a Player passes over Income Tax. Nothing happens.
		
	}
	public void playerLandsOnLuxuryTax(){
		//Player takes a turn and lands on Luxury tax. Their balance decreases by $75.
		
	}
	
	public void playerPassesLuxuryTax(){
		//Player passes Luxury Tax during a turn. Their balance is unchanged.
		
	}
}
