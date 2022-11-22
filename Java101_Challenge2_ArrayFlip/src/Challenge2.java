
public class Challenge2 {

	// 1 2 3 -> 9 8 7
	// 4 5 6 -> 6 5 4
	// 7 8 9 -> 3 2 1
	// arrayFlip1();
	// ----------------
	// 1 2 3 -> 7 4 1
	// 4 5 6 -> 8 5 2
	// 7 8 9 -> 9 6 3
	// arrayFlip2();
	// ----------------
	// "aaaafggg assssvv t"
	// "a4f1g3 a1s4v2 t1"
	// zip();
	public static void main(String[] args) {
		int[][] matris = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		String text = "aaaafggg assssvv t";

		System.out.println("---> ArrayFlip1");
		int[][] fliped1 = arrayFlip1(matris);
		matrisYazdir(fliped1);
		System.out.println("--------------------------------");
		System.out.println("---> ArrayFlip2");
		int[][] fliped2 = arrayFlip2(matris);
		matrisYazdir(fliped2);
		System.out.println("--------------------------------");
		System.out.println("---> Zip");
		zip(text);

	}

	private static void matrisYazdir(int[][] fliped1) {
		for (int i = 0; i < fliped1.length; i++) {
			for (int j = 0; j < fliped1[0].length; j++) {
				System.out.print(fliped1[i][j] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * "aaaafggg assssvv t" -> "a4f1g3 a1s4v2 t1"
	 * 
	 * @param text
	 * 
	 */
	private static void zip(String text) {
		int count = 0;
		char temp = text.charAt(0);
		String zipped = "";

		for (int i = 0; i < text.length(); i++) {

			if (temp == ' ') {
				zipped += ' ';
				temp = text.charAt(i);
			} else {
				if (temp == text.charAt(i)) {
					count++;
				} else {
					zipped += temp;
					zipped += count;
					count = 1;
					temp = text.charAt(i);
				}
			}
		}
		zipped += temp;
		zipped += count;

		System.out.println(zipped);
	}

	/**
	 * // 1 2 3 -> 7 4 1 // 4 5 6 -> 8 5 2 // 7 8 9 -> 9 6 3 // arrayFlip2();
	 * 
	 * @param matris
	 * @return
	 */
	private static int[][] arrayFlip2(int[][] matris) {
		int[][] fliped2 = new int[matris.length][matris[0].length];
		for (int i = 0, k = matris.length - 1; i < matris.length && k >= 0; i++, k--) {
			for (int j = 0; j < matris[i].length; j++) {
				fliped2[j][k] = matris[i][j];
			}
		}
		return fliped2;

	}

	/**
	 * // 1 2 3 -> 9 8 7 // 4 5 6 -> 6 5 4 // 7 8 9 -> 3 2 1 // arrayFlip1();
	 * 
	 * @param matris
	 * @return
	 */
	private static int[][] arrayFlip1(int[][] matris) {
		int[][] fliped1 = new int[matris.length][matris[0].length];
		for (int i = 0, k = matris.length - 1; i < matris.length && k >= 0; i++, k--) {
			for (int j = 0, l = matris[i].length - 1; j < matris[i].length && l >= 0; j++, l--) {
				fliped1[k][l] = matris[i][j];
			}
		}
		return fliped1;
	}

}
