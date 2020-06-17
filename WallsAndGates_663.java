//https://www.youtube.com/watch?v=Pj9378ZsCh4
//https://www.lintcode.com/problem/walls-and-gates/description

public class WallsAndGates_663 {

	// Solution 1
	public static void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					minDistance(rooms, i, j, 0);
				}
			}
		}
	}

	public static void minDistance(int[][] rooms, int i, int j, int sum) {
		if (i < 0 || i > rooms.length - 1 || j < 0 || j > rooms[0].length - 1 || rooms[i][j] < sum) {
			return;
		}

		rooms[i][j] = sum;

		minDistance(rooms, i - 1, j, sum + 1);
		minDistance(rooms, i + 1, j, sum + 1);
		minDistance(rooms, i, j - 1, sum + 1);
		minDistance(rooms, i, j + 1, sum + 1);
	}

	// Solution 2
	public void wallsAndGates2(int[][] rooms) {
		int m = rooms.length, n = rooms[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					dfs(rooms, i, j, visited, 0);
				}
			}
		}
	}

	private void dfs(int[][] rooms, int i, int j, boolean[][] visited, int dist) {
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == -1 || visited[i][j]
				|| rooms[i][j] < dist) {
			return;
		}

		rooms[i][j] = Math.min(rooms[i][j], dist);
		visited[i][j] = true;

		dfs(rooms, i - 1, j, visited, dist + 1);
		dfs(rooms, i + 1, j, visited, dist + 1);
		dfs(rooms, i, j - 1, visited, dist + 1);
		dfs(rooms, i, j + 1, visited, dist + 1);

		visited[i][j] = false;
	}

	public static void main(String[] args) {
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };

		wallsAndGates(rooms);
	}
}
