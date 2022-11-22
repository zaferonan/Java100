package InternetInfrastructure;

import Customer.Customer;

public abstract class Internet {

	private int internetSpeed;
	private double price;
	private Customer customer;
	public Internet(int internetSpeed, double price, Customer customer) {
		this.internetSpeed = internetSpeed;
		this.price = price;
		this.customer = customer;
	}
	public int getInternetSpeed() {
		return internetSpeed;
	}
	public void setInternetSpeed(int internetSpeed) {
		this.internetSpeed = internetSpeed;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
