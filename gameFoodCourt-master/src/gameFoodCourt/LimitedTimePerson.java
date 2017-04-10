package gameFoodCourt;

public class LimitedTimePerson extends Person {
	
	
	public LimitedTimePerson(int tickTime, double eateryTime, double leaveTime, double checkoutTime) {
		super(tickTime, ( (int) eateryTime) * 0.5, ( (int) leaveTime) * 0.5, checkoutTime);
	}
}