//https://leetcode.com/problems/find-peak-element/

public class FindPeakElement_162 {

	public int binarySearch(int[] nums, int low, int high) {

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] > nums[mid + 1]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	public int findPeakElement(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		return binarySearch(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		FindPeakElement_162 peak = new FindPeakElement_162();
		int[] nums = { 1, 2, 3, 1 };
		System.out.println(peak.findPeakElement(nums));
	}

}
