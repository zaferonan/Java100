import Customer.BusinessCustomer;
import Customer.RetailCustomer;
import InternetInfrastructure.GPON;
import InternetInfrastructure.MetroEthernet;

public class MainClass {

	public static void main(String[] args) {
		
		RetailCustomer customer1=new RetailCustomer(1, 5112223344L, "Altieylul/Balikesir", "Zafer Onan", 11111111111L);
		
		GPON gpon=new GPON(100, 200.0, customer1, "Balikesir-33", "BLK-33 GPON1", new int[][]{{5},{8}}, "OFSD 1", 4);
		
		BusinessCustomer customer2=new BusinessCustomer(2, 4440444L, "Besiktas/Istanbul", "Hepsiburada", 33333333L, "Besiktas");
		
		MetroEthernet metro1 =new MetroEthernet(1000, 2500, customer2, "Besiktas-33", "Besiktas-MPLS1", "192.44.1.1", 500);
		System.out.println(gpon.toString());
		System.out.println(metro1.toString());
	}

}
