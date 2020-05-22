import java.util.Arrays;
//https://leetcode.com/problems/3sum-closest/
//http://www.goodtecher.com/leetcode-16-3sum-closest/

public class ThreeSumClosest_16 {

	public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) {
			return -1;
		}

		Arrays.sort(nums);

		int closestSum = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
					closestSum = sum;
				}

				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return closestSum;
	}

	public static void main(String[] args) {
		ThreeSumClosest_16 findSum = new ThreeSumClosest_16();
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(findSum.threeSumClosest(nums, target));
	}

}
