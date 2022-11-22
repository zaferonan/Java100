import Library.HesapMakinesi;

public class JarExample {

	public static void main(String[] args) {

		HesapMakinesi hesapMakinesi = new HesapMakinesi();
		System.out.println("5 x 5 = " + hesapMakinesi.çarp(5, 5));
		System.out.println("45 + 5 = " + hesapMakinesi.ekle(45, 5));
		System.out.println("25 - 8 = " + hesapMakinesi.cikar(25, 8));
		System.out.println("15 / 5 = " + hesapMakinesi.bol(15, 5));

	}

}
