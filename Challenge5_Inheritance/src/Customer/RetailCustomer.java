package Customer;

public class RetailCustomer extends Customer {

	private String customerName;
	private final long customerIdentityNumber;
	public RetailCustomer(int customerID, long customerTelephone, String customerAddress, String customerName,
			long customerIdentityNumber) {
		super(customerID, customerTelephone, customerAddress);
		this.customerName = customerName;
		this.customerIdentityNumber = customerIdentityNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerIdentityNumber() {
		return customerIdentityNumber;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer : 	"+customerName+"Identity Number : "+customerIdentityNumber+" Telephone Number : "+getCustomerTelephone()+" Address : "+getCustomerAddress();
	}
	
	
	

}
