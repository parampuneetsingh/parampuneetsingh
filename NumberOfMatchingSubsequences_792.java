import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfMatchingSubsequences_792 {

	public static int numMatchingSubseq(String S, String[] words) {
		int res = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Set<String> set = new HashSet<>(Arrays.asList(words));

		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		for (String word : set) {
			int idx = 0;
			for (int i = 0; i < S.length(); i++) {
				if (S.charAt(i) == word.charAt(idx)) {
					idx++;
				}
				if (idx == word.length()) {
					res += map.get(word);
					break;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String S = "abcde";
		String[] words = { "a", "bb", "acd", "ace" };
		System.out.println(numMatchingSubseq(S, words));
	}

}
