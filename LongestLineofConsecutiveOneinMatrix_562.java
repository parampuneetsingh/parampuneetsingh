//https://www.lintcode.com/problem/longest-line-of-consecutive-one-in-matrix/
//https://leetfree.com/problems/longest-line-of-consecutive-one-in-matrix.html
//https://www.youtube.com/watch?v=1OrzRFwc9mw

public class LongestLineofConsecutiveOneinMatrix_562 {

	public static int longestLine(int[][] M) {

		if (M.length == 0) {
			return 0;
		}

		int rows = M.length, cols = M[0].length;
		int[][][] dp = new int[rows + 1][cols + 2][4];
		int res = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (M[i][j] == 1) {
					dp[i + 1][j + 1][0] = dp[i + 1][j][0] + 1;
					res = Math.max(res, dp[i + 1][j + 1][0]);

					dp[i + 1][j + 1][1] = dp[i][j + 1][1] + 1;
					res = Math.max(res, dp[i + 1][j + 1][1]);

					dp[i + 1][j + 1][2] = dp[i][j][2] + 1;
					res = Math.max(res, dp[i + 1][j + 1][2]);

					dp[i + 1][j + 1][3] = dp[i][j + 2][3] + 1;
					res = Math.max(res, dp[i + 1][j + 1][3]);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// int[][] M = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } };
		int[][] M = { { 1, 1, 1, 1 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } };
		System.out.println(longestLine(M));
	}

}
