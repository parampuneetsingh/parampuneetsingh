//https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
//https://leetcode.com/problems/longest-palindromic-subsequence/
//https://www.youtube.com/watch?v=_nCsPn7_OgI

public class LongestPalindromicSubsequence_516 {

	public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][s.length() - 1];
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence_516 findSubSeq = new LongestPalindromicSubsequence_516();
		//int result = findSubSeq.longestPalindromeSubseq("agbdba");
		int result = findSubSeq.longestPalindromeSubseq("bbbab");
		System.out.println(result);
	}

}
