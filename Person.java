/**
 * 
 */
package gameFoodCourt;

/**
 * @author   Roger Ferguson
 */
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
	
	public Person() {
		
	}
	
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
		this.tickTime = tickTime;
	}

	public void setEateryTime(double time) {
		this.boothTime = time;
	}
}
