import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

public class MinimumNumberofArrowstoBurstBalloons_452 {

	public static int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}

		Arrays.sort(points, (a, b) -> a[1] - b[1]);

		List<int[]> list = new ArrayList<int[]>();

		list.add(points[0]);

		for (int[] point : points) {
			int[] prev = list.get(list.size() - 1);
			if (prev[1] < point[0]) {
				list.add(point);
			}
		}

		return list.size();
	}

	public static void main(String[] args) {
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };

		System.out.println(findMinArrowShots(points));
	}

}
