//https://leetcode.com/problems/maximum-product-subarray/
//https://www.youtube.com/watch?v=vtJvbRlHqTA
//https://www.youtube.com/watch?v=1s0r7Ixir80

public class MaximumProductSubarray_152 {

	// Brute Force
	public int maxProduct(int[] nums) {
		int res = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			max = nums[i];

			for (int j = i + 1; j < nums.length; j++) {
				sum *= nums[j];
				max = Math.max(max, sum);
			}
			res = Math.max(res, max);
		}

		return res;
	}

	// Dynamic Programming
	public int maxProduct2(int[] nums) {
		int curr_max = nums[0];
		int curr_min = nums[0];
		int final_max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = curr_max;

			curr_max = Math.max(Math.max(curr_max * nums[i], curr_min * nums[i]), nums[i]);
			curr_min = Math.min(Math.min(temp * nums[i], curr_min * nums[i]), nums[i]);

			final_max = (curr_max > final_max) ? curr_max : final_max;
		}
		return final_max;
	}

	public static void main(String[] args) {
		MaximumProductSubarray_152 product = new MaximumProductSubarray_152();
		// int[] nums = { 2, 3, -2, 4 };
		int[] nums = { 2, -5, -2, -4, 3 };
		System.out.println(product.maxProduct2(nums));
	}

}
