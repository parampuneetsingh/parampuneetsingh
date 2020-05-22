import java.util.LinkedList;
import java.util.Queue;

public class TheMaze_490 {

	//https://www.lintcode.com/problem/the-maze/description
	//https://www.youtube.com/watch?v=oMxfdzeD4i0&feature=youtu.be
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		// Ball will not stop -> DFS
		// After hitting the wall, ball can go to any of four directions -> BFS
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		visited[start[0]][start[1]] = true;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[0] == destination[0] && curr[1] == destination[1])
				return true;
			for (int[] dir : dirs) {
				int x = curr[0];
				int y = curr[1];
				while (isValid(x + dir[0], y + dir[1], maze)) {
					x += dir[0];
					y += dir[1];
				}

				if (!visited[x][y]) {
					visited[x][y] = true;
					q.offer(new int[] { x, y });
				}
			}
		}
		return false;
	}

	private boolean isValid(int x, int y, int[][] maze) {
		return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1;
	}

	public static void main(String[] args) {
		TheMaze_490 mze = new TheMaze_490();
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 }, destination = { 3, 2 };
		System.out.println(mze.hasPath(maze, start, destination));

	}

}
