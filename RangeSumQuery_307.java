//https://leetcode.com/problems/range-sum-query-mutable/

public class RangeSumQuery_307 {

	int[] dp;

	public RangeSumQuery_307(int[] nums) {
		dp = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			dp[i] = dp[i - 1] + nums[i - 1];
		}
	}

	public void update(int i, int val) {
		int diff = val - sumRange(i, i);

		for (int j = i + 1; j < dp.length; j++) {
			dp[j] += diff;
		}
	}

	public int sumRange(int i, int j) {
		return dp[j + 1] - dp[i];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5 };
		RangeSumQuery_307 findRange = new RangeSumQuery_307(nums);
		System.out.println(findRange.sumRange(0, 2)); // -> 9
		findRange.update(1, 2);
		System.out.println(findRange.sumRange(0, 2)); // -> 8
	}

}
