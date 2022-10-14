package InternetInfrastructure;

import Customer.Customer;

public abstract class Fiber extends Internet{

	private String central;

	public Fiber(int internetSpeed, double price, Customer customer, String central) {
		super(internetSpeed, price, customer);
		this.central = central;
	}

	public String getCentral() {
		return central;
	}

	public void setCentral(String central) {
		this.central = central;
	}
	
	
}
