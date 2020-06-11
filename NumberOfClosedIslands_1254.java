//https://leetcode.com/problems/number-of-closed-islands/
//https://www.youtube.com/watch?v=MnD8KhBHgRo

public class NumberOfClosedIslands_1254 {

	public int closedIsland(int[][] grid) {
		int count = 0;
		int n = grid.length, m = grid[0].length;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (grid[i][j] == 0) {
					if (findClosedIsland(grid, i, j)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public boolean findClosedIsland(int[][] grid, int i, int j) {

		if (grid[i][j] == 1 || grid[i][j] == -1) {
			return true;
		}

		if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
			return false;
		}

		grid[i][j] = -1;

		boolean up = findClosedIsland(grid, i - 1, j);
		boolean down = findClosedIsland(grid, i + 1, j);
		boolean left = findClosedIsland(grid, i, j - 1);
		boolean right = findClosedIsland(grid, i, j + 1);

		return up && down && left && right;
	}

	public static void main(String[] args) {
		NumberOfClosedIslands_1254 island = new NumberOfClosedIslands_1254();

		int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
		int res = island.closedIsland(grid);
		System.out.println(res);
	}

}
