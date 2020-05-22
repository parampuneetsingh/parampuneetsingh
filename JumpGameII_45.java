//https://leetcode.com/problems/jump-game-ii/
//https://www.youtube.com/watch?v=cETfFsSTGJI

public class JumpGameII_45 {

	public static int jump(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int count = 0;
		int i = 0;
		while (i + nums[i] < nums.length - 1) {
			int maxVal = 0;
			int maxValIndex = 0;
			for (int j = 1; j <= nums[i]; j++) {
				if (nums[j + i] + j > maxVal) {
					maxVal = nums[j + i] + j;
					maxValIndex = i + j;
				}
			}
			i = maxValIndex;
			count++;
		}
		return count + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));
	}

}
