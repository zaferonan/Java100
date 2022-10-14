package Customer;

public abstract class Customer {

	private int customerID;	
	private long customerTelephone;
	private String customerAddress;
	
	
	public Customer(int customerID, long customerTelephone, String customerAddress) {
		this.customerID = customerID;
		this.customerTelephone = customerTelephone;
		this.customerAddress = customerAddress;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public long getCustomerTelephone() {
		return customerTelephone;
	}
	public void setCustomerTelephone(long customerTelephone) {
		this.customerTelephone = customerTelephone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	

	
	
	
}
