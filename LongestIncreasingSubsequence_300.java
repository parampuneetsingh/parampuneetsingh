import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
//https://www.youtube.com/watch?v=CE2b_-XfVDk

public class LongestIncreasingSubsequence_300 {

	public static int checkPossibility(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					max = Math.max(max, dp[i]);
				}
		/* This approach will also work
        for(int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }*/

		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(checkPossibility(nums));
	}

}
