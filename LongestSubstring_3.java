/*Longest Substring without repeating characters
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

public class LongestSubstring_3 {

	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0;
		int max = 0;

		int[] charAry = new int[128];

		while (right < s.length()) {
			while (right < s.length() && charAry[s.charAt(right)] == 0) {
				charAry[s.charAt(right++)]--;
			}

			max = Math.max(max, right - left);
			while (left < right && right < s.length() && charAry[s.charAt(right)] < 0) {
				charAry[s.charAt(left++)]++;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		// String str = "abcabcbb";
		// String str = "pwwkew";
		String str = "dvdf";
		LongestSubstring_3 lols = new LongestSubstring_3();
		System.out.println(lols.lengthOfLongestSubstring(str)); // Solution from Leetcode
	}

}
