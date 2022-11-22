package Phone;

import Phone.abilities.CanTakePicture;
import Phone.abilities.CanTakeVideo;
import Phone.abilities.Rechargeable;
import Phone.abilities.Textable;

public class Nokia6600 extends Telephone implements Textable,CanTakePicture,CanTakeVideo,Rechargeable{

	public Nokia6600(long imeiNumber, long phoneNumber) {
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
		System.out.println("Battery of Nokia 6600 is charged.");
		
	}

	public void takeVideo() {
		System.out.println("The video was taken at Nokia 6600.");
		
	}

	public void takePicture() {
		System.out.println("The picture was taken at Nokia 6600.");
		
	}


}
