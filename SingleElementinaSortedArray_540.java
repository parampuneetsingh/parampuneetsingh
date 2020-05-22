//https://leetcode.com/problems/single-element-in-a-sorted-array/

public class SingleElementinaSortedArray_540 {

	// Time Complexity O(n) and Constant Space complexity
	public int singleNonDuplicate(int[] nums) {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			n ^= nums[i];
		}

		return n;
	}

	// Time Complexity O(log n) and Constant Space complexity
	// https://www.youtube.com/watch?v=jzR8ergqEy8

	public int singleNonDuplicate2(int[] nums) {
		int low = 0, high = nums.length - 1;
		int mid;

		while (low < high) {
			mid = low + (high - low) / 2;
			if (nums[mid] == nums[mid ^ 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return nums[low];
	}

	// Without XOR - Time Complexity O(log n) and Constant Space complexity
	// https://www.youtube.com/watch?v=YeGuJErPQQU

	public int singleNonDuplicate3(int[] nums) {
		int low = 0, high = nums.length - 1;
		int mid;

		while (low < high) {
			mid = low + (high - low) / 2;
			if (mid % 2 == 0) {
				if (nums[mid] == nums[mid + 1]) {
					low = mid + 2;
				} else if (nums[mid] == nums[mid - 1]) {
					high = mid - 2;
				} else {
					return nums[mid];
				}
			} else {
				if (nums[mid] == nums[mid - 1]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return nums[low];
	}

	public static void main(String[] args) {
		SingleElementinaSortedArray_540 findNum = new SingleElementinaSortedArray_540();
		int nums[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		// int nums[] = { 3, 3, 7, 7, 10, 11, 11 };
		System.out.println(findNum.singleNonDuplicate2(nums));
	}

}
