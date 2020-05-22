//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesfromSortedArray_26 {

	public int removeDuplicates2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[count++] = nums[i];
			}
		}

		return count;
	}

	public static int removeDuplicates(int[] nums) {
		int low = 0, high = 0;
		int n = nums.length;

		if (n == 0) {
			return 0;
		}

		while (high < n) {
			if (nums[low] != nums[high]) {
				nums[++low] = nums[high];
			} else {
				high++;
			}
		}

		return low + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicates(nums));
	}

}
