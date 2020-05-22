public class AlienDictionary_953 {

	public static boolean isAlienSorted(String[] words, String order) {
		int[] idx = new int[26];

		for (int i = 0; i < order.length(); i++) {
			idx[order.charAt(i) - 'a'] = i;
		}

		for (int k = 0; k < words.length - 1; k++) {
			String word1 = words[k];
			String word2 = words[k + 1];

			int j = 0;
			int min = Math.min(word1.length(), word2.length());
			for (j = 0; j < min; j++) {
				char a = word1.charAt(j);
				char b = word2.charAt(j);
				// int a = idx[word1.charAt(j) - 'a'];
				// int b = idx[word2.charAt(j) - 'a']
				if (a != b) {
					if (idx[a - 'a'] > idx[b - 'a']) {
						return false;
					}
					break;
				}
			}
			// This only applies in case of [apple, app], where characters are
			// same
			if (j == min && word1.length() > word2.length()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "hello", "leetcode" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";

		System.out.println(isAlienSorted(words, order));
	}

}
