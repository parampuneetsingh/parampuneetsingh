//https://www.youtube.com/watch?v=lBRtnuxg-gU
//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum_64 {

	public static int minPathSum2(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] res = new int[m][n];

		int sum = 0;

		for (int i = 0; i < n; i++) {
			res[0][i] = sum + grid[0][i];
			sum = res[0][i];
		}

		sum = 0;
		for (int j = 0; j < m; j++) {
			res[j][0] = sum + grid[j][0];
			sum = res[j][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
			}
		}

		return res[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		//int[][] grid = { { 1, 2 }, { 1, 1 } };
		System.out.println(minPathSum2(grid));
	}

}
