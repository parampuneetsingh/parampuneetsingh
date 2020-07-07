//https://leetcode.com/problems/find-the-duplicate-number/
//https://www.youtube.com/watch?v=s_nYIsbPqqQ

public class FindDuplicateNumber_287 {

	//Recommended Solution
	public int findDuplicate(int[] nums) {
		// Find the intersection point of the two runners.
		int slow = nums[0];
		int fast = nums[0];

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// Find the "entrance" to the cycle.
		slow = nums[0];

		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}

	// Accepted Solution - Time Complexity O(n), space complexity O(1)
	public int findDuplicate3(int[] nums) {
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
		//Solution 1 is recommended
		System.out.println(find.findDuplicate(nums));
	}
}
