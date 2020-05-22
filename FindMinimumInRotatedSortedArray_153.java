//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimumInRotatedSortedArray_153 {

	// Faster Solution
	public int findMin(int[] nums) {
		int low = 0, high = nums.length - 1;
		int mid;

		while (low < high) {
			mid = low + (high - low) / 2;

			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return nums[low];
	}

	// Leetcode solution
	public int binarySearch(int[] nums, int low, int high) {

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}

			if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}

			if (nums[0] < nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	public int findMin2(int[] nums) {
		int high = nums.length - 1;

		if (nums.length == 1) {
			return nums[0];
		}

		if (nums[high] > nums[0]) {
			return nums[0];
		}

		return binarySearch(nums, 0, high);
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray_153 search = new FindMinimumInRotatedSortedArray_153();
		// int[] nums = { 2, 3, 4, 5, 1 };
		int[] nums = { 3, 4, 5, 1, 2 };
		System.out.println(search.findMin(nums));

	}

}
