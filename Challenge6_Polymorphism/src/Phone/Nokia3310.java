package Phone;

import Phone.abilities.Rechargeable;
import Phone.abilities.Textable;

public class Nokia3310 extends Telephone implements Textable,Rechargeable {

	public Nokia3310(long imeiNumber, long phoneNumber) {
		super(imeiNumber, phoneNumber);
		
	}

	@Override
	public void call(long phoneNumber) {
		System.out.println(phoneNumber+" called!!");
		
	}

	@Override
	public void answer() {
		System.out.println("Phone call is answered");
		
	}

	public void text(long phoneNumber, String message) {
		System.out.println("This message : '"+message+"'  is texted to "+phoneNumber);
		
	}

	@Override
	public void chargeBattery() {
		System.out.println("Battery of Nokia 3310 is charged.");
		
	}



	

}
