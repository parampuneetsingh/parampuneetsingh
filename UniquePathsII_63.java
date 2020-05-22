//https://leetcode.com/problems/unique-paths-ii/
//https://www.youtube.com/watch?v=l47iMtKvZxM

public class UniquePathsII_63 {

	//Solution 1 is Better and easy to understand
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1 || obstacleGrid.length == 0) {
			return 0;
		}

		int m = obstacleGrid.length, n = obstacleGrid[0].length;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				break;
			}
			dp[0][i] = 1;
		}

		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					continue;
				}
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int n = obstacleGrid.length, m = obstacleGrid[0].length;

		int[][] dp = new int[n + 1][m + 1];

		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		dp[1][1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (obstacleGrid[i - 1][j - 1] == 0) {
					dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		UniquePathsII_63 unique = new UniquePathsII_63();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		// int[][] obstacleGrid = { { 0, 1 }, { 1, 0 } };
		// int[][] obstacleGrid = { { 0, 0 } };
		//Solution 1 is Better
		System.out.println(unique.uniquePathsWithObstacles(obstacleGrid));
	}

}
