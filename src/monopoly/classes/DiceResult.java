package monopoly.classes;

public class DiceResult {

	public int numberOne = 0;
	public int numberTwo = 0;

	public DiceResult(){
		
	}
	
	public DiceResult(int resultOne,int resultTwo){
		this.numberOne = resultOne;
		this.numberTwo = resultTwo;
	}
	public boolean isDoubles(){
		return numberOne == numberTwo;
	}
}
