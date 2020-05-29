import java.util.Arrays;

//https://leetcode.com/problems/valid-triangle-number/
//https://www.youtube.com/watch?v=gSgNqlTg9AY

public class ValidTriangleNumber_611 {

	// Binary Search Solution
	public static int triangleNumber(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		int count = 0;
		for (int i = n - 1; i > 1; i--) {
			int low = 0, high = i - 1;
			while (low < high) {
				if (nums[low] + nums[high] > nums[i]) {
					count += high - low;
					high--;
				} else {
					low++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 4 };
		System.out.println(triangleNumber(nums));
	}

}
