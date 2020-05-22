//https://leetcode.com/problems/sort-colors/
//https://www.youtube.com/watch?v=uvB-Ns_TVis

public class SortColors_75 {

	public void sortColors(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int start = 0, idx = 0, end = nums.length - 1;

		while (start < end && idx <= end) {
			if (nums[idx] == 0) {
				int temp = nums[start];
				nums[start++] = nums[idx];
				nums[idx++] = temp;
			} else if (nums[idx] == 2) {
				int temp = nums[end];
				nums[end--] = nums[idx];
				nums[idx] = temp;
			} else {
				idx++;
			}
		}

		for (int k : nums) {
			System.out.println(k + " ");
		}
	}

	public static void main(String[] args) {
		SortColors_75 sort = new SortColors_75();
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		sort.sortColors(nums);
	}

}
