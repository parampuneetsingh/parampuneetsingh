//https://leetcode.com/problems/search-a-2d-matrix/

public class SearchaTwoDMatrix_74 {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}

		int low = 0, high = matrix[0].length - 1;

		while (low < matrix.length && high >= 0) {
			if (matrix[low][high] == target) {
				return true;
			} else if (target > matrix[low][high]) {
				low++;
			} else {
				high--;
			}
		}

		return false;
	}
	 
	public static void main(String[] args) {
		int[][] matrix = {
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
				};
		int target = 3;
		
		System.out.println(searchMatrix(matrix, target));
	}

}
