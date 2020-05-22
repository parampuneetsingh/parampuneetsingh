//https://leetcode.com/problems/minimum-size-subarray-sum/
//https://www.youtube.com/watch?v=jKF9AcyBZ6E

public class MinimumSizeSubarraySum_209 {

	public static int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int ans = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			while (sum >= s) {
				ans = Math.min(ans, i + 1 - left);
				sum -= nums[left++];
			}
		}
		return (ans != Integer.MAX_VALUE) ? ans : 0;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));
	}

}
