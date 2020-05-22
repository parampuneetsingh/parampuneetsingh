//https://leetcode.com/problems/spiral-matrix-ii/

public class SpiralMatrixII_59 {

	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];

		int left = 0, top = 0;
		int right = n - 1, bottom = n - 1;

		int size = n * n;
		int count = 0;
		for (int i = left; i <= right; i++) {
			for (int j = left; j <= right && count < size; j++) {
				res[i][j] = ++count;
			}
			top++;
			for (int j = top; j <= bottom && count < size; j++) {
				res[j][bottom] = ++count;
			}

			bottom--;
			for (int k = bottom; k >= left && count < size; k--) {
				res[right][k] = ++count;
			}
			right--;
			for (int l = right; l >= top && count < size; l--) {
				res[l][left] = ++count;
			}
			left++;
		}
		return res;
	}

	public static void main(String[] args) {
		SpiralMatrixII_59 matrix = new SpiralMatrixII_59();
		matrix.generateMatrix(3);
	}

}
