//https://www.youtube.com/watch?v=Jg4u9S1n8Q8
//https://leetcode.com/problems/minimum-falling-path-sum/

public class MinimumFallingPathSum_931 {

	public static int minFallingPathSum(int[][] A) {
		int m = A.length, n = A[0].length;

		int[][] dp = new int[m][n];

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			dp[0][i] = A[0][i];
		}

		for (int j = 1; j < m; j++) {
			for (int k = 0; k < n; k++) {
				if (k == 0) {
					dp[j][k] = A[j][k] + Math.min(dp[j - 1][k], dp[j - 1][k + 1]);
				} else if (k == n - 1) {
					dp[j][k] = A[j][k] + Math.min(dp[j - 1][k], dp[j - 1][k - 1]);
				} else {
					dp[j][k] = A[j][k] + Math.min(Math.min(dp[j - 1][k - 1], dp[j - 1][k]), dp[j - 1][k + 1]);
				}
			}
		}

		for (int l : dp[m - 1]) {
			ans = Math.min(ans, l);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum(A));
	}

}
