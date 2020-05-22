//https://leetcode.com/problems/non-decreasing-array/

public class NonDecreasingArray_665 {

	public static boolean checkPossibility(int[] nums) {
		int max = 0, pre = Integer.MIN_VALUE, index = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				if (nums[i] >= pre) {
					nums[i - 1] = nums[i];
				} else {
					nums[i] = nums[i - 1];
				}
				max++;
			}
			if (max > 1) {
				return false;
			}
			pre = nums[index++];
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 4, 2, 3 };
		System.out.println(checkPossibility(nums));
	}

}
