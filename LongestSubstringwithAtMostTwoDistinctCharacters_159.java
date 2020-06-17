import java.util.HashMap;
import java.util.Map;

//https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/

public class LongestSubstringwithAtMostTwoDistinctCharacters_159 {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int slow = 0;
		int fast = 0;
		int maxLen = 0;
		int n = s.length();

		while (fast < n) {
			map.put(s.charAt(fast), map.getOrDefault(s.charAt(fast), 0) + 1);

			while (map.size() > 2) {
				map.put(s.charAt(slow), map.getOrDefault(s.charAt(slow), 0) - 1);
				if (map.get(s.charAt(slow)) <= 0) {
					map.remove(s.charAt(slow));
				}

				slow++;
			}

			fast++;
			maxLen = Math.max(maxLen, fast - slow);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String s = "eceba";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}

}
