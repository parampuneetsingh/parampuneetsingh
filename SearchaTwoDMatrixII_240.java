//https://leetcode.com/problems/search-a-2d-matrix-ii/

public class SearchaTwoDMatrixII_240 {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}

		int i = 0, j = matrix[0].length - 1;

		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		SearchaTwoDMatrixII_240 search = new SearchaTwoDMatrixII_240();
		int[][] matrix = { 
				{ 1, 4, 7, 11, 15 }, 
				{ 2, 5, 8, 12, 19 }, 
				{ 3, 6, 9, 16, 22 }, 
				{ 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 5;
		boolean res = search.searchMatrix(matrix, target);
		System.out.println(res);
	}

}
