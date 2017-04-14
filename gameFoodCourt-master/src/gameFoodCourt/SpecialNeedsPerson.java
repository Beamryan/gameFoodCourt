package gameFoodCourt;

public class SpecialNeedsPerson extends Person {
	
	public SpecialNeedsPerson(int tickTime, double eateryTime, double leaveTime, double cashiersTime) {
		super(tickTime, eateryTime*4, leaveTime*3, cashiersTime*2);
	}
}