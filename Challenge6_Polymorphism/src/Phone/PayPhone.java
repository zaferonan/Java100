package Phone;

public class PayPhone implements Phone {
	
	private final long phoneNumber;
	private double balance;

	public PayPhone(long phoneNumber) {
		super();
		this.phoneNumber=phoneNumber;
		this.balance=0;
	}
	
	public void insertToken(int tokenAmount) {
		this.balance+=10.0*tokenAmount;
		System.out.println(tokenAmount+" token is inserted to payphone");

	}
	

	public double getBalance() {
		return balance;
	}

	@Override
	public void call(long phoneNumber) {
		if(balance>0) {
			balance-=10;
			System.out.println(phoneNumber+" called!!");
		}else {
			System.out.println("Insufficient balance!! Please insert a token to payphone.");
		}
		
	}

	@Override
	public void answer() {
		System.out.println("Phone call is answered");
		
	}

	@Override
	public long getPhoneNumber() {
		
		return this.phoneNumber;
	}
	
	
	

}
