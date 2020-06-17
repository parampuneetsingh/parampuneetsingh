import java.util.Arrays;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class KthSmallestElementinaSortedMatrix_378 {

	public static int kthSmallest(int[][] matrix, int k) {
		int s = matrix.length;
		int[] arr = new int[s * s];
		int p = 0;
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				arr[p] = matrix[i][j];
				p++;
			}
		}
		Arrays.sort(arr);
		return arr[k - 1];
	}

	public static void main(String[] args) {
		int[][] matrix = {
			   { 1,  5,  9},
			   {10, 11, 13},
			   {12, 13, 15}
			};
		
		int k = 8;
		System.out.println(kthSmallest(matrix, k));
	}

}
