package gameFoodCourt;

public class SpecialNeeds extends Person {
	
	public SpecialNeeds(int tickTime, double eateryTime, double leaveTime, double cashiersTime) {
		super(tickTime, eateryTime*4, leaveTime*3, cashiersTime*2);
	}
}
