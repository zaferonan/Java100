package Phone;

public abstract class Telephone implements Phone {

	private final long imeiNumber;
	private long phoneNumber;
	
	public Telephone(long imeiNumber, long phoneNumber) {
		super();
		this.imeiNumber = imeiNumber;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getImeiNumber() {
		return imeiNumber;
	}


	
	
	
}
