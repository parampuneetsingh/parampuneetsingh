import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

public class LongestWordInDictionary_524 {

	public String findLongestWord(String s, List<String> d) {
		PriorityQueue<String> pq = new PriorityQueue<String>(
				(a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

		for (String word : d) {
			int length = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == word.charAt(length)) {
					length++;
				}

				if (length == word.length()) {
					pq.add(word);
					break;
				}
			}
		}

		return (!pq.isEmpty()) ? pq.poll() : "";
	}

	public static void main(String[] args) {
		LongestWordInDictionary_524 word = new LongestWordInDictionary_524();
		// String s = "abpcplea";
		// String[] d = { "ale", "apple", "monkey", "plea" };
		String s = "bab";
		String[] d = { "ba", "ab", "a", "b" };
		System.out.println(word.findLongestWord(s, Arrays.asList(d)));
	}

}
