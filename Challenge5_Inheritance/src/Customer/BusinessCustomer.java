package Customer;

public class BusinessCustomer extends Customer{
	
	private String businessName;
	private final long customerTaxNumber;
	private final String customerTaxDepartment;
	
	public BusinessCustomer(int customerID, long customerTelephone, String customerAddress, String businessName,
			long customerTaxNumber, String customerTaxDepartment) {
		super(customerID, customerTelephone, customerAddress);
		this.businessName = businessName;
		this.customerTaxNumber = customerTaxNumber;
		this.customerTaxDepartment = customerTaxDepartment;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public long getCustomerTaxNumber() {
		return customerTaxNumber;
	}

	public String getCustomerTaxDepartment() {
		return customerTaxDepartment;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer : 	"+businessName+"Tax Number : "+customerTaxNumber+" Telephone Number : "+getCustomerTelephone()+" Address : "+getCustomerAddress();
	}
	
	

}
