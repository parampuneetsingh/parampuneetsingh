import java.util.HashSet;
import java.util.Set;

//https://www.lintcode.com/problem/number-of-distinct-islands/
//https://www.youtube.com/watch?v=c1ZxUOHlulo

public class NumberofDistinctIslands_694 {

	public int numberofDistinctIslands(int[][] grid) {
		Set<String> sets = new HashSet<String>();

		int n = grid.length, m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					String path = findIslands(grid, i, j, "X");
					sets.add(path);
				}
			}
		}
		return sets.size();
	}

	public String findIslands(int[][] grid, int i, int j, String start) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == -1) {
			return start;
		}

		grid[i][j] = -1;
		String up = findIslands(grid, i - 1, j, "U");
		String down = findIslands(grid, i + 1, j, "D");
		String left = findIslands(grid, i, j - 1, "L");
		String right = findIslands(grid, i, j + 1, "R");

		return start + up + down + left + right;
	}

	public static void main(String[] args) {
		NumberofDistinctIslands_694 islands = new NumberofDistinctIslands_694();
		// int[][] grid = { { 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, {
		// 0, 1, 0, 1, 1 } };
		int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
		int res = islands.numberofDistinctIslands(grid);
		System.out.println(res);
	}

}
