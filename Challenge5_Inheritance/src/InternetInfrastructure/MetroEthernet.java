package InternetInfrastructure;

import Customer.Customer;

public class MetroEthernet extends Fiber {
	
	private String mpls;
	private String switchIP;
	private double fiberDistance;
	public MetroEthernet(int internetSpeed, double price, Customer customer, String central, String mpls, String switchIP,
			double fiberDistance) {
		super(internetSpeed, price, customer, central);
		this.mpls = mpls;
		this.switchIP = switchIP;
		this.fiberDistance = fiberDistance;
	}
	public String getMpls() {
		return mpls;
	}
	public void setMpls(String mpls) {
		this.mpls = mpls;
	}
	public String getSwitchIP() {
		return switchIP;
	}
	public void setSwitchIP(String switchIP) {
		this.switchIP = switchIP;
	}
	public double getFiberDistance() {
		return fiberDistance;
	}
	public void setFiberDistance(double fiberDistance) {
		this.fiberDistance = fiberDistance;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Metro --> Central : "+getCentral()+" - MPLS : "+mpls+" - Switch IP : "+switchIP+" - Internet Speed : "+getInternetSpeed()+"Mbps";
	}

}
