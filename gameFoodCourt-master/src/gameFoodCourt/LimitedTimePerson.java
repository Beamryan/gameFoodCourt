package gameFoodCourt;

/** Created by Ryan Beam */
public class LimitedTimePerson extends Person {
	
	private int tickTime;
	private Eatery Destination;
	
	// max time person stays in line
	protected double boothTime;
	
	public double getBoothTime() {
		return boothTime;
	}
	
	public Eatery getDestination() {
		return Destination;
	}

	public void setDestination(Eatery destination) {
		Destination = destination;
	}
	
	public int getTickTime() {
		return tickTime;
	}

	public void setTickTime(int tickTime) {
		this.tickTime = tickTime / 2;
	}

	public void setEateryTime(double time) {
		this.boothTime = time / 2;
	}

}
