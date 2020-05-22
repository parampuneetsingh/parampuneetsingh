//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
//https://www.youtube.com/watch?v=7xMVc2lPXhI

public class CountSquareSubmatriceswithAllOnes_1277 {

	public static int countSquares(int[][] matrix) {
		int total = 0;

		int m = matrix.length, n = matrix[0].length;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + matrix[i - 1][j - 1];
					total += dp[i][j];
				}
			}
		}

		return total;
	}
    
	public static void main(String[] args) {
		int[][] matrix = {
				{0,0,0},
				{0,1,0},
				{0,1,0},
				{1,1,1},
				{1,1,0}};
		
		System.out.println(countSquares(matrix));
	}

}
