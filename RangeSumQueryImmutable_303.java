//https://leetcode.com/problems/range-sum-query-immutable/

public class RangeSumQueryImmutable_303 {

	int[] rangeArray;

	public RangeSumQueryImmutable_303(int[] nums) {
		rangeArray = new int[nums.length + 1];

		for (int i = 1; i <= nums.length; i++) {
			rangeArray[i] = nums[i - 1] + rangeArray[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		return rangeArray[j + 1] - rangeArray[i];
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		RangeSumQueryImmutable_303 range = new RangeSumQueryImmutable_303(nums);
		range.sumRange(0, 2); // -> 1
		range.sumRange(2, 5); // -> -1
		range.sumRange(0, 5); // -> -3
	}

}
