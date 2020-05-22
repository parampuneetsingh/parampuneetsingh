//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchRotatedSortedArray_33 {

	public int searchArray(int[] nums, int start, int end, int target) {
		int mid;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	// Better Solution
	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int mid;
		int low = 0, high = nums.length - 1;
		while (low < high) {
			mid = low + (high - low) / 2;
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		if (target <= nums[nums.length - 1]) {
			return searchArray(nums, low, nums.length - 1, target);
		} else {
			return searchArray(nums, 0, low - 1, target);
		}
	}

	public int search2(int[] nums, int target) {
		int low = 0;
		int length = nums.length - 1;

		while (low <= length) {
			int mid = (low + length) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[low] <= nums[mid]) {
				if (target >= nums[low] && target < nums[mid]) {
					length = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			if (nums[mid] <= nums[length]) {
				if (target > nums[mid] && target <= nums[length]) {
					low = mid + 1;
				} else {
					length = mid - 1;
				}
			}
		}
		return nums[low] == target ? low : -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		SearchRotatedSortedArray_33 srsa = new SearchRotatedSortedArray_33();
		System.out.println(srsa.search(nums, target));
	}

}
