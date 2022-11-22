package Phone;

import Phone.abilities.CanTakePicture;
import Phone.abilities.CanTakeVideo;
import Phone.abilities.InernetConnectable;
import Phone.abilities.Rechargeable;
import Phone.abilities.ScreenTouchable;
import Phone.abilities.Textable;
import Phone.abilities.VideoCallable;

public class AndroidPhone extends Telephone implements Textable,CanTakePicture,CanTakeVideo,InernetConnectable,Rechargeable,ScreenTouchable,VideoCallable{

	private boolean internetConnection;
	public AndroidPhone(long imeiNumber, long phoneNumber) {
		super(imeiNumber, phoneNumber);
		// TODO Auto-generated constructor stub
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
		System.out.println("Battery of Android Phone is charged.");
		
	}

	public void takeVideo() {
		System.out.println("The video was taken at Android Phone.");
		
	}

	public void takePicture() {
		System.out.println("The picture was taken at Android Phone.");
		
	}
	@Override
	public void videoCall(long phoneNumber) {
		if(internetConnection) {
			System.out.println(phoneNumber+" video called!!");
		}else {
			System.out.println("No Internet connection. Please connect to the internet for video call.");
		}
		
	}

	@Override
	public void touch() {
		System.out.println("Touched on the screen at Android Phone");
		
	}
	

	@Override
	public void connectToInternet() {
		internetConnection=true;
		System.out.println("Connected to internet.");
		
	}

	@Override
	public void searchOnInternet(String searchedText) {
		if(internetConnection) {
			System.out.println(searchedText+" searched on the internet.");
		}else {
			System.out.println("No Internet connection. Please connect to the internet for searching.");
		}
		
	}

	

	

}
