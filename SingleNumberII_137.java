//https://leetcode.com/problems/single-number-ii/
//https://www.youtube.com/watch?v=ny1tk1AkON8

public class SingleNumberII_137 {

	public int singleNumber(int[] nums) {
		int result = 0;

		for (int i = 0; i < 32; i++) {
			int t = 0;
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & (1 << i)) != 0) {
					t++;
				}
			}
			result |= ((t % 3) << i);
		}
		return result;
	}

	public static void main(String[] args) {
		SingleNumberII_137 number = new SingleNumberII_137();
		int[] nums = { 2, 2, 3, 2 };
		System.out.println(number.singleNumber(nums));
	}

}
