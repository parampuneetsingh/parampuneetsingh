//https://www.lintcode.com/problem/valid-word-square/
//https://www.youtube.com/watch?v=bP2H9lAq3E8

public class ValidWordSquare_422 {

	public boolean validWordSquare(String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (int j = i; j < words.length; j++) {
				if (i + j >= words.length) {
					continue;
				}
				char c1 = words[i].charAt(j);
				char c2 = words[j].charAt(i);

				if (c1 != c2) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidWordSquare_422 valid = new ValidWordSquare_422();
		String[] words = { "abcd", "bnrt", "crmy", "dtye" };
		System.out.println(valid.validWordSquare(words));
	}

}
