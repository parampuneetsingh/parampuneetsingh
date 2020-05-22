//https://www.youtube.com/watch?v=FkjFlNtTzc8
public class IslandParameter_463 {

	public static int islandPerimeter(int[][] grid) {

		int total = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					total += 4;

					if (j != 0 && grid[i][j - 1] == 1) {
						total -= 2;
					}

					if (i != 0 && grid[i - 1][j] == 1) {
						total -= 2;
					}
				}
			}
		}

		return total;
	}

	public static void main(String[] args) {
		/*
		 * int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
		 */
		int[][] grid = { { 1, 1 } };
		islandPerimeter(grid);

	}

}
