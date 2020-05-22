
public class LongestMountainInArray_845 {

	public static int longestMountain(int[] A) {
		int max = Integer.MIN_VALUE;
		int left = 0, right = 0;
		int n = A.length;

		while (left < A.length - 1 && right < A.length - 1) {
			right = left;

			while (right < A.length - 1 && A[right] < A[right + 1]) {
				right++;
			}

			if (right == n - 1 || right - left < 1 || A[right] == A[right + 1]) {
				left = right + 1;
				continue;
			}

			while (right < A.length - 1 && A[right] > A[right + 1]) {
				right++;
			}

			max = Math.max(max, right - left + 1);
			left = right;
		}

		return (max < 3) ? 0 : max;

	}

	public static void main(String[] args) {
		/*
		 * int[] A = { 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0,
		 * 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
		 * 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0,
		 * 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1
		 * };
		 */

		int[] A = { 2, 1, 4, 7, 3, 2, 5 };
		System.out.println(longestMountain(A));
	}

}
