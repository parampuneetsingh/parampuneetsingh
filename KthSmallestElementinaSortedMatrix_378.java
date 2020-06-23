//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class KthSmallestElementinaSortedMatrix_378 {

	public int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;

		int lower = matrix[0][0];
		int upper = matrix[m - 1][m - 1];

		while (lower < upper) {
			int mid = lower + ((upper - lower) >> 1);
			int count = count(matrix, mid);
			if (count < k) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
		}

		return upper;
	}

	private int count(int[][] matrix, int target) {
		int m = matrix.length;
		int i = m - 1;
		int j = 0;
		int count = 0;

		while (i >= 0 && j < m) {
			if (matrix[i][j] <= target) {
				count += i + 1;
				j++;
			} else {
				i--;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };

		int k = 8;
		KthSmallestElementinaSortedMatrix_378 ele = new KthSmallestElementinaSortedMatrix_378();
		System.out.println(ele.kthSmallest(matrix, k));
	}

}
