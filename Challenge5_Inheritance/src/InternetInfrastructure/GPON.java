package InternetInfrastructure;

import Customer.Customer;

public class GPON extends Fiber {
	
	private String olt;
	private int[][] oltPort;
	private String ofsd;
	private int customerPort;
	public GPON(int internetSpeed, double price, Customer customer, String central, String olt, int[][] oltPort,
			String ofsd, int customerPort) {
		super(internetSpeed, price, customer, central);
		this.olt = olt;
		this.oltPort = oltPort;
		this.ofsd = ofsd;
		this.customerPort = customerPort;
	}
	public String getOlt() {
		return olt;
	}
	public void setOlt(String olt) {
		this.olt = olt;
	}
	public int[][] getOltPort() {
		return oltPort;
	}
	public void setOltPort(int[][] oltPort) {
		this.oltPort = oltPort;
	}
	public String getOfsd() {
		return ofsd;
	}
	public void setOfsd(String ofsd) {
		this.ofsd = ofsd;
	}
	public int getCustomerPort() {
		return customerPort;
	}
	public void setCustomerPort(int customerPort) {
		this.customerPort = customerPort;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GPON --> Central : "+getCentral()+" - Olt : "+getOlt()+" - OLT Port : "+oltPort[0][0]+"/"+oltPort[1][0]+" - Internet Speed : "+getInternetSpeed()+"Mbps";
	}

}
