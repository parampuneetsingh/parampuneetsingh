//https://leetcode.com/problems/partition-equal-subset-sum/
//https://www.youtube.com/watch?v=s6FhG--P7z0

public class PartitionEqualSubsetSum_416 {

	public boolean subsetSum(int[] nums, int sum) {
		boolean[][] dp = new boolean[nums.length + 1][sum + 1];

		for (int i = 0; i <= nums.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - nums[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[nums.length][sum];
	}

	public boolean canPartition(int[] nums) {
		int total = 0;
		for (int i : nums) {
			total += i;
		}

		if (total % 2 != 0) {
			return false;
		}

		int sum = total / 2;

		return subsetSum(nums, sum);
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum_416 subset = new PartitionEqualSubsetSum_416();
		int[] nums = { 1, 5, 11, 5 };
		System.out.println(subset.canPartition(nums));
	}

}
