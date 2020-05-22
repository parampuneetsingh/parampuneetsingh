
public class LongestRepeatingSubstring_1062 {

	public static int longestRepeatingSubstring(String S) {
		if (S == null || S.length() == 0) {
			return 0;
		}

		int n = S.length();
		int res = 0;

		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (S.charAt(i - 1) == S.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}

		return res;
	}
	
/*	Dynamic Programming Explanation
		 a  b  b  a  b  a
	 [0, 0, 0, 0, 0, 0, 0], 
	a[0, 0, 0, 0, 0, 0, 0], 
	b[0, 0, 0, 0, 0, 0, 0], 
	b[0, 0, 1, 0, 0, 0, 0], 
	a[0, 1, 0, 0, 0, 0, 0], 
	b[0, 0, 2, 1, 0, 0, 0], 
	a[0, 1, 0, 0, 2, 0, 0]
	
*/
	public static void main(String[] args) {
		String S = "abbaba";
		System.out.println(longestRepeatingSubstring(S));
	}
}
