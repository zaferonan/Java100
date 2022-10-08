
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;




public class MainClass {
	/*
	 * Konsoldan girilen string içerisinde hangi harften kaç tane bulunduğunu sıralı
	 * bir şekilde yazmak, Örnek: numan -> n2u1m1a1 Numan karaaslan n3u1m1a5
	 * 1k1r1s1l1
	 * 
	 * Konsoldan girilen ifadeyi zipleyip harfleri listeye atmak (map ve arraylist
	 * ile) Örnek: numankaraaslan -> numakrsl
	 * 
	 */

	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();

		zipWmap(str);
		
		zip2Wmap(str);
		

	}
	/**
	 * Map ile konsoldan girilen string içerisinde hangi harften kaç tane
	 * bulunduğunu sıralı bir şekilde yazmak Örnek: numan -> n2u1m1a1 Numan
	 * karaaslan n3u1m1a5 1k1r1s1l1
	 * 
	 * @param str
	 */
	private static void zipWmap(String str) {
		Map<Character, Integer> CharMap =new LinkedHashMap<>();		
		String zippedText = "";
		for (int i = 0; i < str.length(); i++) {
			char character=Character.toLowerCase(str.charAt(i));
				CharMap.putIfAbsent(character, countOfChar(str, character));
			}
		
		for (java.util.Map.Entry<Character,Integer> entry: CharMap.entrySet()) {
			zippedText += entry.getKey()+""+entry.getValue();
		}
		System.out.println("-> Zip With Map :");
		System.out.println(zippedText);
	}



	/**
	 * Map ile konsoldan girilen ifadeyi zipleyip harfleri listeye atmak
	 * Örnek: numankaraaslan -> numakrsl
	 * 
	 * @param str
	 */
	private static void zip2Wmap(String str) {
		
		Map<Character, Integer> CharMap =new LinkedHashMap<>();		
		String zippedText = "";
		for (int i = 0; i < str.length(); i++) {
			char character=Character.toLowerCase(str.charAt(i));
				CharMap.putIfAbsent(character, countOfChar(str, character));
			}
		for (java.util.Map.Entry<Character,Integer> entry: CharMap.entrySet()) {
			zippedText += entry.getKey();
		}
		System.out.println("-> Zip2 With Map :");
		System.out.println(zippedText);
	}

	/**
	 * @param str
	 * @param character
	 * @return count of character at String str
	 */
	private static int countOfChar(String str, char character) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.toLowerCase(str.charAt(i)) == character) {
				count++;
			}
		}
		return count;
	}

}
