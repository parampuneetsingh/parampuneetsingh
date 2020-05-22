//https://leetcode.com/problems/24-game/
//https://www.youtube.com/watch?v=ET_HIyJTl1E

public class TwentyFourGame_679 {

	public boolean judgePoint24(int[] nums) {
		double[] a = new double[] { nums[0], nums[1], nums[2], nums[3] };
		return helper(a);
	}

	private boolean helper(double[] a) {
		if (a.length == 1)
			return Math.abs(a[0] - 24) < 0.0001;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				double[] d = new double[a.length - 1];

				for (int k = 0, index = 0; k < a.length; k++) {
					if (k != i && k != j) {
						d[index++] = a[k];
					}
				}

				for (double num : compute(a[i], a[j])) {
					d[d.length - 1] = num;
					if (helper(d))
						return true;
				}
			}
		}

		return false;
	}

	private double[] compute(double x, double y) {
		return new double[] { x + y, x - y, y - x, x * y, x / y, y / x };
	}

	public static void main(String[] args) {
		TwentyFourGame_679 check24Game = new TwentyFourGame_679();
		int[] nums = { 4, 1, 8, 7 };
		System.out.println(check24Game.judgePoint24(nums));
	}

}
