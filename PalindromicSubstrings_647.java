//https://leetcode.com/problems/palindromic-substrings/
//https://www.youtube.com/watch?v=QX8RBlXvKXg

public class PalindromicSubstrings_647 {

	public static int countSubstrings(String s) {
		int res = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1])) {
					dp[i][j] = true;
					res++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "abbaa";
		System.out.println(countSubstrings(s));
	}

}
