//https://leetcode.com/problems/set-matrix-zeroes/

public class SetMatrixZeroes_73 {

	public void setZeroes(int[][] matrix) {
		Boolean isCol = false;
		int R = matrix.length;
		int C = matrix[0].length;

		for (int i = 0; i < R; i++) {

			// Since first cell for both first row and first column is the same i.e.
			// matrix[0][0]
			// We can use an additional variable for either the first row/column.
			// For this solution we are using an additional variable for the first column
			// and using matrix[0][0] for the first row.
			if (matrix[i][0] == 0) {
				isCol = true;
			}

			for (int j = 1; j < C; j++) {
				// If an element is zero, we set the first element of the corresponding row and
				// column to 0
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		// Iterate over the array once again and using the first row and first column,
		// update the elements.
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// See if the first row needs to be set to zero as well
		if (matrix[0][0] == 0) {
			for (int j = 0; j < C; j++) {
				matrix[0][j] = 0;
			}
		}

		// See if the first column needs to be set to zero as well
		if (isCol) {
			for (int i = 0; i < R; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public void setZeroes2(int[][] matrix) {
		int n = matrix.length, m = matrix[0].length;
		boolean[] row = new boolean[n];
		boolean[] column = new boolean[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (row[i]) {
				nullifyRow(matrix, i);
			}
		}

		for (int j = 0; j < m; j++) {
			if (column[j]) {
				nullifyCol(matrix, j);
			}
		}
	}

	public void nullifyRow(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}

	public void nullifyCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes_73 setMatrix = new SetMatrixZeroes_73();
		// int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		// int[][] matrix = { { -2147483648 }, { 2 }, { 3 } };
		setMatrix.setZeroes(matrix);
	}

}
