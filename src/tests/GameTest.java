package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import monopoly.MonopolyGame;
import monopoly.classes.DiceRoller;
import monopoly.classes.MonopolyBoard;
import monopoly.classes.MonopolyPlayer;
import monopoly.classes.RoundPlayer;
import monopoly.classes.TurnTaker;
import monopoly.interfaces.IMonopolyPlayer;

public class GameTest {

	@Test
	public void createGameWithTwoPlayers() {
		//Create a game with two players named Horse and Car.
		
		MonopolyGame game = new MonopolyGame();
		IMonopolyPlayer player = new MonopolyPlayer();
		player.setPlayerName("Horse");
		game.addPlayer(player);
		player = new MonopolyPlayer();
		player.setPlayerName("Car");
		game.addPlayer(player);
		Assert.assertEquals("Horse",game.getPlayers().get(0).getPlayerName());
		Assert.assertEquals("Car",game.getPlayers().get(1).getPlayerName());
	}
	@Test
	public void createGameWithIncorrectNumberPlayers(){
		//	Try to create a game with < 2 or > 8 players. When attempting to play the game, it will fail.
		boolean caughtException1 = false;
		boolean caughtException2 = false;
		MonopolyGame game = new MonopolyGame();
		IMonopolyPlayer player = new MonopolyPlayer();
		game.addPlayer(player);
		try{
			game.startGame();
		}catch(Exception e){
			caughtException1 = true;
		}
		int i = 0;
		try{
			for(i= 0;i < 50;i ++){
				player = new MonopolyPlayer();
				game.addPlayer(player);
			}
		}catch(Exception e){
			caughtException2 = true;
			Assert.assertEquals(i, 7);
		}
		Assert.assertEquals(true,caughtException1);
		Assert.assertEquals(true,caughtException2);
	}
	@Test
	public void createGameWithTwoPlayersWithRandomOrders()
	{
		//Create a game with two players named Horse and Car. Within creating 100 games, both orders [Horse, Car] and [car, horse] occur.
		
		String firstResult = null;
		boolean everNotEqual = false;
		for(int i= 0;i < 100;i ++){
			MonopolyGame game = new MonopolyGame();
			IMonopolyPlayer player = new MonopolyPlayer();
			player.setPlayerName("Horse");
			game.addPlayer(player);
			player = new MonopolyPlayer();
			player.setPlayerName("Car");
			game.addPlayer(player);
			game.randomizePlayerOrders();
			if(firstResult == null){
				firstResult = "";
				for(IMonopolyPlayer inPlayer:game.getPlayers()){
					firstResult += inPlayer.getPlayerName()+",";
				}
			}else{
				String nextResult = "";
				for(IMonopolyPlayer inPlayer:game.getPlayers()){
					nextResult += inPlayer.getPlayerName()+",";
				}
				everNotEqual = everNotEqual || !firstResult.equals(nextResult);
			}
		}
		Assert.assertEquals(true,everNotEqual);
	}
	
	@Test
	public void createGameAndPlayBeforeStarting(){
		MonopolyGame game = new MonopolyGame();
		boolean exception = false;
		for(int i = 0;i < 8;i ++){
			IMonopolyPlayer player = new MonopolyPlayer();
			game.addPlayer(player);
		}
		try{
			game.playRound();
		}catch(Exception e){
			exception = true;
		}
		Assert.assertEquals(true,exception);
	}
	@Test
	public void createGameAndPlay20Rounds(){
		MonopolyGame game = new MonopolyGame();
		game.setTurnTaker(new TurnTaker(new DiceRoller()));
		game.setBoard(new MonopolyBoard());
		game.setRoundPlayer(new RoundPlayer());
		for(int i = 0;i < 8;i ++){
			IMonopolyPlayer player = new MonopolyPlayer();
			game.addPlayer(player);
		}
		game.startGame();
		for(int i = 0;i < 20;i ++){
			game.playRound();
		}
		Assert.assertEquals(game.getRounds(), 20);
		for(int i = 0;i < 8;i ++){
			Assert.assertEquals(20,game.getPlayers().get(0).getTurnNumber());
		}
	}
	

}
