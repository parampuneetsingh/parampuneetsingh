//https://leetcode.com/problems/max-area-of-island/
//https://www.youtube.com/watch?v=W8VuDt0eb5c

public class MaxAreaOfIsland_695 {

	public int dfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
			return 0;
		}

		grid[i][j] = 0;

		int count = 1;
		count += dfs(grid, i - 1, j);
		count += dfs(grid, i + 1, j);
		count += dfs(grid, i, j - 1);
		count += dfs(grid, i, j + 1);

		return count;
	}

	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, dfs(grid, i, j));
				}
			}
		}

		return max;
	}
	    
	public static void main(String[] args) {
		MaxAreaOfIsland_695 maxArea = new MaxAreaOfIsland_695();
		
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}};

		System.out.println(maxArea.maxAreaOfIsland(grid));
	}

}
