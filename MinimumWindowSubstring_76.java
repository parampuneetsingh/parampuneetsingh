//https://leetcode.com/problems/minimum-window-substring/
//https://www.youtube.com/watch?v=vvVe7qxOz9U

public class MinimumWindowSubstring_76 {

	public static String minWindow(String s, String t) {
		if (s.length() == 0) {
			return "";
		}

		int n = s.length();
		int[] charAry = new int[128];

		for (char c : t.toCharArray()) {
			charAry[c]++;
		}

		int min = Integer.MAX_VALUE, count = 0;
		int left = 0, right = 0, minStart = -1, minEnd = -1;

		while (right < n) {
			if (charAry[s.charAt(right)] > 0) {
				count++;
			}

			charAry[s.charAt(right)]--;

			if (count == t.length()) {
				while (left < right && charAry[s.charAt(left)] < 0) {
					charAry[s.charAt(left)]++;
					left++;
				}

				if (right - left < min) {
					min = right - left;
					minStart = left;
					minEnd = right + 1;
				}

				charAry[s.charAt(left++)]++;
				count--;
			}

			right++;
		}

		return minStart == -1 ? "" : s.substring(minStart, minEnd);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(minWindow(s, t));
	}

}
