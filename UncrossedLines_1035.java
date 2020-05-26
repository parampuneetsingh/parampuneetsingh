//https://leetcode.com/problems/uncrossed-lines/
//https://www.youtube.com/watch?v=jLv-5coG-qQ

public class UncrossedLines_1035 {

	public static int maxUncrossedLines(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		int[] A = { 2, 5, 1, 2, 5 }, B = { 10, 5, 2, 1, 5, 2 };
		System.out.println(maxUncrossedLines(A, B));
	}

}
