//https://leetcode.com/problems/range-sum-query-2d-immutable/
//https://www.youtube.com/watch?v=PwDqpOMwg6U

public class RangeSumQuery2D_304 {

	int[][] mat;

	/* Solution 2 By Parampuneet Singh
	public NumMatrix(int[][] matrix) {
	        if (matrix.length == 0 || matrix[0].length == 0) {
	            return;
	        }
	        
	        int m = matrix.length, n = matrix[0].length;
	        mat = new int[m][n+1];
	        
	        for(int i=0; i<m; i++) {
	            for(int j=0; j<n; j++) {
	                mat[i][j+1] = mat[i][j] + matrix[i][j];
	            }
	        }
	    }

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += mat[i][col2 + 1] - mat[i][col1];
		}
		return sum;
	}
	 */
	
	// Solution 1
	public RangeSumQuery2D_304(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		mat = new int[matrix.length + 1][matrix[0].length + 1];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				mat[r + 1][c + 1] = mat[r + 1][c] + mat[r][c + 1] + matrix[r][c] - mat[r][c];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return mat[row2 + 1][col2 + 1] - mat[row1][col2 + 1] - mat[row2 + 1][col1] + mat[row1][col1];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		RangeSumQuery2D_304 findSum = new RangeSumQuery2D_304(matrix);
		System.out.println(findSum.sumRegion(2, 1, 4, 3));
	}

}
