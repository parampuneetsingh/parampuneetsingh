
public class DiagonalTraverse_498 {

	public static int[] findDiagonalOrder(int[][] matrix) {
		int n = matrix.length, m = matrix[0].length;
		int[] res = new int[m * n];
		int idx = 0;
		// Initialize indexes of element to be printed next
		int i = 0, j = 0;

		// Direction is initially from down to up
		boolean isUp = true;

		// Traverse the matrix till all elements get traversed
		for (int k = 0; k < m * n;) {
			// If isUp = true then traverse from downward
			// to upward
			if (isUp) {
				for (; i >= 0 && j < n; j++, i--) {
					res[idx++] = matrix[i][j];
					k++;
				}

				// Set i and j according to direction
				if (i < 0 && j <= n - 1)
					i = 0;
				if (j == n) {
					i = i + 2;
					j--;
				}
			}

			// If isUp = 0 then traverse up to down
			else {
				for (; j >= 0 && i < n; i++, j--) {
					res[idx++] = matrix[i][j];
					k++;
				}

				// Set i and j according to direction
				if (j < 0 && i <= n - 1)
					j = 0;
				if (i == n) {
					j = j + 2;
					i--;
				}
			}

			// Revert the isUp to change the direction
			isUp = !isUp;
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// int[][] matrix = {{ 2, 3 }};
		System.out.println(findDiagonalOrder(matrix));
	}
}