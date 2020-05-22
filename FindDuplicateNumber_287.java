import java.util.Arrays;

//https://leetcode.com/problems/find-the-duplicate-number/
//https://www.youtube.com/watch?v=s_nYIsbPqqQ

public class FindDuplicateNumber_287 {

	// O(nlogn) complexity because of Arrays.sort
	public int binarySearch(int[] nums, int low, int high) {
		Arrays.sort(nums);

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == nums[mid + 1]) {
				return nums[mid];
			} else if (mid < nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return nums[low];
	}

	// Accepted Solution - Time Complexity O(n), space complexity O(1)
	public int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]);

			if (nums[index] < 0) {
				return index;
			}

			nums[index] = -nums[index];
		}

		return -1;
	}

	// Time Complexity O(n), space complexity O(1)
	public int findDuplicate2(int[] nums) {
		int sum = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}

		// Formula to find One Duplicate
		return sum - ((n - 1) * n) / 2;
	}

	public static void main(String[] args) {
		FindDuplicateNumber_287 find = new FindDuplicateNumber_287();
		int[] nums = { 1, 3, 4, 2, 2 };
		find.binarySearch(nums, 0, nums.length - 1);
		System.out.println(find.findDuplicate(nums));
	}
}
