
public class MaximumSubarray_53 {

	//https://leetcode.com/problems/maximum-subarray/
	public int findMaxSum(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int sum = nums[0];
		int previous = nums[0];
		for (int i = 1; i < nums.length; i++) {
			previous = Math.max(previous + nums[i], nums[i]);
			sum = Math.max(previous, sum);
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] nums = //{1,2,-4,1,3,-2,3,-1};
		{ -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray_53 subAry = new MaximumSubarray_53();
		int response2 = subAry.findMaxSum(nums);
		System.out.println(response2);

	}

}
