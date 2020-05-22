import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeatingCharacters_3 {

	public static int lengthOfLongestSubstring(String s) {
		int max = 0, n = s.length();
		Set<Character> set = new HashSet<Character>();
		int left = 0, right = 0;

		while (left < n && right < n) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right++));
				max = Math.max(max, right - left);
			} else {
				set.remove(s.charAt(left++));
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
