import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
//https://www.programcreek.com/2014/09/leetcode-longest-substring-with-at-least-k-repeating-characters-java/

public class LongestSubstringWithAtLeastKRepeatingChars_395 {

	//Its a hard question
	public static int longestSubstring(String s, int k) {
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			counter.put(c, counter.getOrDefault(c, 0) + 1);
		}

		HashSet<Character> splitSet = new HashSet<Character>();
		for (char c : counter.keySet()) {
			if (counter.get(c) < k) {
				splitSet.add(c);
			}
		}

		if (splitSet.isEmpty()) {
			return s.length();
		}

		int max = 0;
		int i = 0, j = 0;
		while (j < s.length()) {
			char c = s.charAt(j);
			if (splitSet.contains(c)) {
				if (j != i) {
					max = Math.max(max, longestSubstring(s.substring(i, j), k));
				}
				i = j + 1;
			}
			j++;
		}

		if (i != j)
			max = Math.max(max, longestSubstring(s.substring(i, j), k));

		return max;
	}

	public static void main(String[] args) {
		//String s = "ababbc";
		//int k = 2;
		String s = "ababacb";
		int k = 3;
		System.out.println(longestSubstring(s, k));
	}

}
