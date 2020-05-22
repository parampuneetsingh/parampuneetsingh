//https://leetcode.com/problems/check-if-it-is-a-straight-line/

public class CheckIfItIsaStraightLine_1232 {

	//https://www.youtube.com/watch?v=C_B_cSypzIE
	/*public boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length <= 2) {
			return true;
		}

		int x0 = coordinates[0][0], y0 = coordinates[0][1];
		int x1 = coordinates[1][0], y1 = coordinates[1][1];

		for (int i = 2; i < coordinates.length - 1; i++) {
			int x = coordinates[i][0], y = coordinates[i][1];

			if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) {
				return false;
			}
		}

		return true;
	}*/
	
	public float findSlope(int[] a, int[] b) {
		if (a[0] == b[0]) {
			return Float.MAX_VALUE;
		}
		return (float) (b[1] - a[1]) / (b[0] - a[0]);
	}

	// Better and Easy Solution
	// https://www.youtube.com/watch?v=PsZ_MmFBzJA
	public boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length <= 2) {
			return true;
		}

		float n = findSlope(coordinates[0], coordinates[1]);

		for (int i = 2; i < coordinates.length - 1; i++) {
			float m = findSlope(coordinates[i], coordinates[0]);
			if (m != n) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		CheckIfItIsaStraightLine_1232 straightLine = new CheckIfItIsaStraightLine_1232();
		//int[][] coordinates = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
		//int[][] coordinates = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
		int[][] coordinates= {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
		System.out.println(straightLine.checkStraightLine(coordinates));
	}

}
