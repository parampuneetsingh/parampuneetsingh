

//https://www.programcreek.com/2014/10/leetcode-sparse-matrix-multiplication-java/

public class SparseMatrixMultiplication_311 {

	public int[][] multiply(int[][] A, int[][] B) {
		// validity check

		int[][] C = new int[A.length][B[0].length];

		for (int i = 0; i < C.length; i++) {
			for (int k = 0; k < A[0].length; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < C[0].length; j++) {
						C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}

		return C;
	}

	public static void main(String[] args) {
		SparseMatrixMultiplication_311 multiple = new SparseMatrixMultiplication_311();
		int[][] A = { { 2, 0, 0 }, { -3, 0, 4 } };
		int[][] B = { { 5, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2 } };
		//Result Output [[10, 0, 0], [-15, 0, 8]]
		multiple.multiply(A, B);
	}
}