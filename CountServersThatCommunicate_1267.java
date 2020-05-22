//https://leetcode.com/problems/count-servers-that-communicate/
//https://www.youtube.com/watch?v=IXiVGUobxUA

public class CountServersThatCommunicate_1267 {

	public static int countServers(int[][] grid) {

		int m = grid.length, n = grid[0].length;
		int resp = 0;

		int[] hrzAry = new int[m];
		int[] vertAry = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					hrzAry[i]++;
					vertAry[j]++;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && (hrzAry[i] > 1 || vertAry[j] > 1)) {
					resp++;
				}
			}
		}
		
		return resp;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		//int[][] grid = { { 1, 0 }, { 1, 1 } };
		System.out.println(countServers(grid));
	}

}
