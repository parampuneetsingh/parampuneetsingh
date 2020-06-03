import java.util.Arrays;

//https://leetcode.com/problems/two-city-scheduling/
//https://www.youtube.com/watch?v=2U5KkOy9pRE

public class TwoCityScheduling_1029 {

	public static int twoCitySchedCost(int[][] costs) {
		int minCost = 0;
		int n = costs.length;
		Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
		for (int i = 0; i < n; i++) {
			if (i < n / 2) {
				minCost += costs[i][0];
			} else {
				minCost += costs[i][1];
			}
		}

		return minCost;
	}

	public static void main(String[] args) {
		// int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
		int[][] costs = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
		System.out.println(twoCitySchedCost(costs));

	}

}
