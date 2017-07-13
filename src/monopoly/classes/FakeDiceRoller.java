package monopoly.classes;

import monopoly.interfaces.IDiceRoller;

public class FakeDiceRoller implements IDiceRoller {

	int numberOne = 0;
	int numberTwo = 0;
	
	public FakeDiceRoller(int numberOne, int numberTwo){
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
	}
	@Override
	public DiceResult rollDice() {
		DiceResult res = new DiceResult(numberOne,numberTwo);
		return res;
	}

}
