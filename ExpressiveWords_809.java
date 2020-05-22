
public class ExpressiveWords_809 {

	public int expressiveWords(String S, String[] words) {
		int sLength = S.length();
		int output = 0;

		for (String word : words) {
			int i = 0, j = 0, k = 0;
			int wordLength = word.length();

			if (wordLength > sLength) {
				continue;
			}

			while (i < wordLength || j < sLength) {
				if (j == sLength) {
					continue;
				}
				if (i < wordLength && j < sLength && word.charAt(i) == S.charAt(j)) {
					i++;
					j++;
				} else {
					k = j - 1;
					if (k < 0 || S.charAt(k) != S.charAt(j)) {
						break;
					}

					while (k - 1 >= 0 && S.charAt(k - 1) == S.charAt(k)) {
						k--;
					}
					while (j < sLength && S.charAt(j) == S.charAt(j - 1))
						j++;
					if (j - k < 3) {
						break;
					}
				}
			}
			if (i == wordLength && j == sLength) {
				output++;
			}
		}

		return output;
	}

	public static void main(String[] args) {
		ExpressiveWords_809 eWords = new ExpressiveWords_809();
		//String S = "heeellooo";
		//String[] words = { "hello", "hi", "helo" };
		String S = "lee";
		String[] words = { "le" };
		System.out.println(eWords.expressiveWords(S, words));
	}
}
