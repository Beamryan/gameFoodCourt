package gameFoodCourt;

public class Person {
	private int tickTime;
	private double eateryTime;
	private double checkoutTime;
	private double leaveTime;
	private Eatery Destination;
	
	public Person(int tickTime, double eateryTime, double leaveTime, double checkoutTime) {
		this.tickTime = tickTime;
		this.eateryTime = eateryTime;
		this.leaveTime = leaveTime;
		this.checkoutTime = checkoutTime;
	}	
	
	public Person()
	{
		
	}

	public void setEateryTime(double d) {
		this.eateryTime = d;	
	}

	public void setTickTime(int tick) {
		this.tickTime = tick;
	}

	public void setDestination(Eatery eatery) {
		this.Destination = eatery;
	}

	public Eatery getDestination() {
		return Destination;
	}

	public double getBoothTime() {
		return leaveTime;
	}
}