package main;

import Phone.AndroidPhone;
import Phone.Nokia3310;
import Phone.Nokia6600;
import Phone.PayPhone;

public class MainClass {

	public static void main(String[] args) {
		Nokia3310 n3310=new Nokia3310(123123123123123L, 5311231212L);
		n3310.chargeBattery();
		PayPhone pPhone=new PayPhone(2663221234L);
		
		n3310.call(2663221234L);		
		pPhone.answer();
		System.out.println("------------------------");
		pPhone.call(5311231212L);
		pPhone.insertToken(1);
		pPhone.call(5311231212L);
		pPhone.call(5311231212L);
		System.out.println("------------------------");
		
		AndroidPhone aPhone=new AndroidPhone(523123123123123L, 5312221133L);
		aPhone.chargeBattery();
		aPhone.searchOnInternet("Gelecegi Yazanlar");
		aPhone.connectToInternet();
		aPhone.searchOnInternet("Gelecegi Yazanlar");
		aPhone.videoCall(5315552233L);
		aPhone.touch();
		System.out.println("------------------------");
		Nokia6600 n6600=new Nokia6600(323123123123123L, 5441223423L);
		n6600.chargeBattery();
		n6600.text(5312221133L, "Merhaba");
		n6600.takePicture();
		

	}

}
