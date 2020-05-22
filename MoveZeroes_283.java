//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes_283 {

	// Better Solution
	public static void moveZeroes(int[] arr) {
		int len = arr.length;
		for (int slow = 0, fast = 0; fast < len; fast++) {
			if (arr[fast] != 0) {
				if (slow != fast) {
					arr[slow] = arr[fast];
					arr[fast] = 0;
				}
				slow++;
			}
		}
	}

	public static void moveZeroes2(int[] nums) {
		int lastZero = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[lastZero++] = nums[i];
			}
		}

		for (int j = lastZero; j < nums.length; j++) {
			nums[j] = 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12, 0, 15 };
		moveZeroes(nums);
	}

}
