//https://www.lintcode.com/problem/shortest-word-distance/description

public class ShortestWordDistance_243 {

	public static int shortestDistance(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int a = -1, b = -1;

		for (int i = 0; i < words.length; i++) {
			if (word1.equals(words[i])) {
				if (b != -1) {
					min = Math.min(min, Math.abs(b - i));
				}
				a = i;
			} else if (word2.equals(words[i])) {
				if (a != -1) {
					min = Math.min(min, Math.abs(a - i));
				}
				b = i;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		String word1 = "makes", word2 = "coding";
		System.out.println(shortestDistance(words, word1, word2));
	}

}
