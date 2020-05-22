//https://leetcode.com/problems/house-robber-ii/
public class HouseRobberII_213 {

	public int findMax(int[] nums, int i, int j) {
		if (i == j) {
			return nums[i];
		}
		int[] dp = new int[nums.length];
		dp[i] = nums[i];
		dp[i + 1] = Math.max(nums[i], nums[i + 1]);

		for (int k = i + 2; k <= j; k++) {
			dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k]);
		}

		return dp[j];
	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int a = findMax(nums, 0, nums.length - 2);
		int b = findMax(nums, 1, nums.length - 1);

		return Math.max(a, b);
	}

	public static void main(String[] args) {
		HouseRobberII_213 maxRob = new HouseRobberII_213();
		int[] nums = { 1, 2, 3, 1 };
		System.out.println(maxRob.rob(nums));
	}

}
