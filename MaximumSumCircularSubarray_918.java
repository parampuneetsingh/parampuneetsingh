//https://leetcode.com/problems/maximum-sum-circular-subarray/
//https://www.youtube.com/watch?v=os4B7MlHAbs&t=903s

public class MaximumSumCircularSubarray_918 {

	public static int maxSubarraySumCircular(int[] A) {
		int n = A.length;
		int sum = A[0];
		int max = A[0];
		int min = A[0];
		int maxTotal = A[0];
		int minTotal = A[0];

		for (int i = 1; i < n; i++) {
			max = Math.max(max + A[i], A[i]);
			/*if (max + A[i] > A[i]) {
				max += A[i];
			} else {
				max = A[i];
			}*/

			maxTotal = Math.max(maxTotal, max);

			min = Math.min(min + A[i], A[i]);
			/*if (min + A[i] < A[i]) {
				min += A[i];
			} else {
				min = A[i];
			}*/

			minTotal = Math.min(minTotal, min);

			sum += A[i];
		}

		if (sum == minTotal)
			return maxTotal;

		return Math.max(maxTotal, sum - minTotal);
	}

	public static void main(String[] args) {
		int[] A = { 0, -1, 5, -3, 5, 1 };
		System.out.println(maxSubarraySumCircular(A));
	}

}
