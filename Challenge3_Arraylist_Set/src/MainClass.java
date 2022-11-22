import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

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

		zipWarraylist(str);
		zipWset(str);
		zip2Warraylist(str);
		zip2Wset(str);

	}

	/**
	 * Set ile konsoldan girilen ifadeyi zipleyip harfleri listeye atmak Örnek:
	 * numankaraaslan -> numakrsl
	 * 
	 * @param str
	 */
	private static void zip2Wset(String str) {
		Set<Character> CharSet = new LinkedHashSet<>();
		String zippedText = "";
		for (int i = 0; i < str.length(); i++) {
			CharSet.add(str.charAt(i));
		}
		for (Character character : CharSet) {
			zippedText += character;
		}
		System.out.println("-> Zip2 With Set :");
		System.out.println(zippedText);
	}

	/**
	 * ArrayList ile konsoldan girilen ifadeyi zipleyip harfleri listeye atmak
	 * Örnek: numankaraaslan -> numakrsl
	 * 
	 * @param str
	 */
	private static void zip2Warraylist(String str) {
		ArrayList<Character> CharList = new ArrayList<>();
		String zippedText = "";
		for (int i = 0; i < str.length(); i++) {
			if (!CharList.contains(str.charAt(i))) {
				CharList.add(str.charAt(i));
			}
		}
		for (Character character : CharList) {
			zippedText += character;
		}
		System.out.println("-> Zip2 With ArrayList :");
		System.out.println(zippedText);
	}

	/**
	 * Set ile konsoldan girilen string içerisinde hangi harften kaç tane
	 * bulunduğunu sıralı bir şekilde yazmak, Örnek: numan -> n2u1m1a1 Numan
	 * karaaslan n3u1m1a5 1k1r1s1l1
	 * 
	 * @param str
	 */
	private static void zipWset(String str) {
		Set<Character> CharSet = new LinkedHashSet<>();
		String zippedText = "";
		for (int i = 0; i < str.length(); i++) {
			CharSet.add(str.charAt(i));
		}
		for (Character character : CharSet) {
			zippedText += character;
			zippedText += countOfChar(str, character);
		}
		System.out.println("-> Zip With Set :");
		System.out.println(zippedText);
	}

	/**
	 * ArrayList ile konsoldan girilen string içerisinde hangi harften kaç tane
	 * bulunduğunu sıralı bir şekilde yazmak Örnek: numan -> n2u1m1a1 Numan
	 * karaaslan n3u1m1a5 1k1r1s1l1
	 * 
	 * @param str
	 */
	private static void zipWarraylist(String str) {
		ArrayList<Character> CharList = new ArrayList<>();
		String zippedText = "";
		for (int i = 0; i < str.length(); i++) {
			if (!CharList.contains(str.charAt(i))) {
				CharList.add(str.charAt(i));
			}
		}
		for (Character character : CharList) {
			zippedText += character;
			zippedText += countOfChar(str, character);
		}
		System.out.println("-> Zip With ArrayList :");
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
			if (str.charAt(i) == character) {
				count++;
			}
		}
		return count;
	}

}
