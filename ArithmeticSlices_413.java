//https://leetcode.com/problems/arithmetic-slices/

public class ArithmeticSlices_413 {

	public int numberOfArithmeticSlices(int[] A) {
		int[] dp = new int[A.length];
		int sum = 0;

		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp[i] = dp[i - 1] + 1;
				sum += dp[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		ArithmeticSlices_413 nums = new ArithmeticSlices_413();
		int[] A = { 1, 2, 3, 4 };
		System.out.println(nums.numberOfArithmeticSlices(A));
	}

}
