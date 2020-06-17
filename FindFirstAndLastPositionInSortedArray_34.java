//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FindFirstAndLastPositionInSortedArray_34 {

	public static int findIndex(int[] nums, int target, boolean left) {
		int low = 0, high = nums.length - 1;
		int mid;
		int res = -1;

		while (low <= high) {
			mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				res = mid;
				if (left) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return res;
	}

	public static int[] searchRange(int[] nums, int target) {
		int left = findIndex(nums, target, true);
		int right = findIndex(nums, target, false);

		return new int[] { left, right };
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		System.out.println(searchRange(nums, target));
	}

}
