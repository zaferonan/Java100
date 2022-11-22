package InternetInfrastructure;

import Customer.Customer;

public class Copper_Based extends Internet {
	
	private double copperDistance;
	private int maximumSpeed;
	private String[][] portInfo;
	
	public Copper_Based(int internetSpeed, double price, Customer customer, double copperDistance, int maximumSpeed,
			String[][] portInfo) {
		super(internetSpeed, price, customer);
		this.copperDistance = copperDistance;
		this.maximumSpeed = maximumSpeed;
		this.portInfo = portInfo;
	}
	
	public double getCopperDistance() {
		return copperDistance;
	}
	public void setCopperDistance(double copperDistance) {
		this.copperDistance = copperDistance;
	}
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
	public String[][] getPortInfo() {
		return portInfo;
	}
	public void setPortInfo(String[][] portInfo) {
		this.portInfo = portInfo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Copper-Based Internet --> Copper Distance : "+copperDistance+" m - MaximumSpeed : "+maximumSpeed+" Mbps - Copper Port : "+portInfo[0][0]+"/"+portInfo[1][0]	;
	}

	
}
