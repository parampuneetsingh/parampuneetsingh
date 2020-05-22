//https://github.com/openset/leetcode/tree/master/problems/longest-substring-with-at-most-k-distinct-characters
//https://www.youtube.com/watch?v=O8Cy495shf0

public class LongestSubstringwithAtMostKDistinctCharacters_340 {

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int count = 0, max = 0;
		int[] charAry = new int[128];

		int left = 0, right = 0;

		while (right < s.length()) {
			
			if (charAry[s.charAt(right++)]++ == 0) {
				count++;
			}

			while (count > k) {
				charAry[s.charAt(left)]--;
				if (charAry[s.charAt(left++)] == 0) {
					count--;
				}
			}

			max = Math.max(max, right - left);

		}

		return max;
	}

	public static void main(String[] args) {
		String s = "eceba";
		int k = 2;
		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
	}

}
