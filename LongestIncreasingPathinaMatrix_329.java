//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
//https://www.youtube.com/watch?v=ZAmxc4Qrqi8

public class LongestIncreasingPathinaMatrix_329 {

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int[][] dp = new int[matrix.length][matrix[0].length];

		int res = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (dp[i][j] == 0) {
					dfs(matrix, i, j, dp, Integer.MIN_VALUE);
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
	}

	private int dfs(int[][] matrix, int i, int j, int[][] dp, int prev) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev) {
			return 0;
		}

		if (dp[i][j] != 0)
			return dp[i][j];

		int up = dfs(matrix, i - 1, j, dp, matrix[i][j]);
		int down = dfs(matrix, i + 1, j, dp, matrix[i][j]);
		int left = dfs(matrix, i, j - 1, dp, matrix[i][j]);
		int right = dfs(matrix, i, j + 1, dp, matrix[i][j]);

		dp[i][j] = Math.max(up, Math.max(down, Math.max(left, right))) + 1;

		return dp[i][j];
	}

	public static void main(String[] args) {
		LongestIncreasingPathinaMatrix_329 path = new LongestIncreasingPathinaMatrix_329();
		
		int[][] matrix = {
				  {3,4,5},
				  {3,2,6},
				  {2,2,1}
				};
		
		System.out.println(path.longestIncreasingPath(matrix));
	}

}
