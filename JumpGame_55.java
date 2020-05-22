//https://leetcode.com/problems/jump-game/
//https://www.youtube.com/watch?v=frY6pwhc4vQ
//https://www.youtube.com/watch?v=muDPTDrpS28

public class JumpGame_55 {

	public boolean canJump(int[] nums) {
		int idxLength = nums.length;
		int maxJump = 0;

		for (int i = 0; i < idxLength; i++) {
			maxJump = Math.max(maxJump, nums[i] + i);
			if (maxJump == i) {
				break;
			}
		}

		return maxJump >= idxLength - 1;
	}

	public static void main(String[] args) {
		JumpGame_55 jump = new JumpGame_55();
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(jump.canJump(nums));
	}

}
