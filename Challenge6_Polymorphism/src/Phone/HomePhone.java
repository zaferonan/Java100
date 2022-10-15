package Phone;

public class HomePhone implements Phone {

	private long phoneNumber;
	
	
	public HomePhone(long phoneNumber) {
		
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void call(long phoneNumber) {
		System.out.println(phoneNumber+" called!!");
		
	}

	@Override
	public void answer() {
		System.out.println("Phone call is answered");
		
	}

	@Override
	public long getPhoneNumber() {
		
		return this.phoneNumber;
	}
	
	
	public void setPhoneNumber(long phoneNumber) {
		
		this.phoneNumber=phoneNumber;
	}

	
}
