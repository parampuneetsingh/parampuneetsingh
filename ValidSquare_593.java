import java.util.HashMap;

//https://leetcode.com/problems/valid-square/

public class ValidSquare_593 {

	public int distance(int[] a, int[] b) {
		return ((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;

		int[][] points = new int[][] { p1, p2, p3, p4 };

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int dist = distance(points[i], points[j]);
				if (dist == 0) {
					return false;
				}
				max = Math.max(max, dist);
				map.put(dist, map.getOrDefault(dist, 0) + 1);
			}
		}

		return map.size() == 2 && map.get(max) == 2;
	}

	public static void main(String[] args) {
		ValidSquare_593 square = new ValidSquare_593();
		//int[] p1 = { 0, 0 }, p2 = { 1, 1 }, p3 = { 1, 0 }, p4 = { 0, 1 };
		int[] p1 = {-7213,-701}, p2	= {-7214,-700}, p3 = {-7215,-701}, p4 = {-7214,-702};
		System.out.println(square.validSquare(p1, p2, p3, p4));
	}

}
