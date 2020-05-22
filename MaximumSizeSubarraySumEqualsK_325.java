import java.util.HashMap;

//https://www.lintcode.com/problem/maximum-size-subarray-sum-equals-k/my-submissions
//https://www.youtube.com/watch?v=l5fw70Sw62I

public class MaximumSizeSubarraySumEqualsK_325 {

	// Time Complexity O(n^2)
	public int maxSubArrayLen2(int[] nums, int k) {
		int max = Integer.MIN_VALUE;

		if (nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return (nums[0] == k) ? 1 : 0;
		}

		for (int i = 0; i < nums.length; i++) {
			int t = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				t += nums[j];

				if (t == k) {
					max = Math.max(max, (j + 1) - i);
				}
			}
		}
		return max;
	}

	// Time Complexity O(n)
	public int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int result = 0;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				result = Math.max(result, i - map.get(sum - k));
			}
			map.putIfAbsent(sum, i);
		}

		return result;
	}

	public static void main(String[] args) {
		MaximumSizeSubarraySumEqualsK_325 subArray = new MaximumSizeSubarraySumEqualsK_325();
		// int[] nums = { 1, -1, 5, -2, 3 };
		int[] nums = { -2, -1, 2, 1 };
		System.out.println(subArray.maxSubArrayLen(nums, 1));
	}

}
