//https://leetcode.com/problems/search-insert-position/

public class SearchInsertPosition_35 {

	public int binarySearch(int[] nums, int target, int low, int high) {

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = low + 1;
			}
		}

		return low;
	}

	public static void main(String[] args) {
		SearchInsertPosition_35 SIP = new SearchInsertPosition_35();
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(SIP.binarySearch(nums, 2, 0, nums.length - 1));
	}

}
