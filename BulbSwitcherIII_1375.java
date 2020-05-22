//https://leetcode.com/problems/bulb-switcher-iii/

public class BulbSwitcherIII_1375 {

	public static int numTimesAllBlue(int[] light) {
		int max = 0;
		int res = 0;

		for (int i = 0; i < light.length; i++) {
			max = Math.max(max, light[i]);
			if (max - 1 == i) {
				res++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] light = { 2, 1, 3, 5, 4 };
		System.out.println(numTimesAllBlue(light));
	}

}
