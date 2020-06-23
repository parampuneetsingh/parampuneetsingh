//https://leetcode.com/problems/flipping-an-image/

public class FlippinganImage_832 {

	public static int[][] flipAndInvertImage(int[][] A) {

		int m = A.length, n = A[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < (n + 1) / 2; j++) {
				int t = A[i][j] ^ 1;
				A[i][j] = A[i][n - j - 1] ^ 1;
				A[i][n - j - 1] = t;
			}
		}

		return A;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } }; // O/P -> {{1,0,0},{0,1,0},{1,1,1}}
		flipAndInvertImage(A);
	}

}
