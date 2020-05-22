//https://leetcode.com/problems/single-number-iii/
//https://leetcode.com/problems/single-number-iii/discuss/68922/A-summary-of-Java-solutions

public class SingleNumberIII_260 {

	public int[] singleNumber(int[] nums) {
		int x=0, y=0;
		
		int xor = 0;

		for (int num : nums) {
			xor ^= num;
		}

		xor &= (-xor);
		
		for (int num : nums) {
			if ((num & xor) == 0) {
				x ^= num;
			} else {
				y ^= num;
			}
		}
		return new int[] { x, y };
	}

	public static void main(String[] args) {
		SingleNumberIII_260 number = new SingleNumberIII_260();
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		number.singleNumber(nums);
	}

}