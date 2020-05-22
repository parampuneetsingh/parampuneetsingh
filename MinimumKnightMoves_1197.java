import java.util.HashSet;
import java.util.LinkedList;

//https://github.com/openset/leetcode/tree/master/problems/minimum-knight-moves
//https://www.bbsmax.com/A/MAzAQYRyz9/

public class MinimumKnightMoves_1197 {

	int[][] dirs = new int[][] { { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { -2, -1 }, { -2, 1 }, { 2, -1 },
			{ 2, 1 } };

	public int minKnightMoves(int x, int y) {
		x = Math.abs(x);
		y = Math.abs(y);

		HashSet<int[]> visited = new HashSet<>();
		LinkedList<int[]> que = new LinkedList<>();
		que.add(new int[] { 0, 0 });
		visited.add(new int[] {0,0});

		int step = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			while (size-- > 0) {
				int[] cur = que.poll();
				if (cur[0] == x && cur[1] == y) {
					return step;
				}

				for (int[] dir : dirs) {
					int i = cur[0] + dir[0];
					int j = cur[1] + dir[1];
					int[] path = new int[]{i, j};
					
					if (!visited.contains(path) && i >= -1 && j >= -1) {
						que.add(new int[] { i, j });
						visited.add(new int[] {i, j});
					}
				}
			}

			step++;
		}

		return -1;
	}

	public static void main(String[] args) {
		MinimumKnightMoves_1197 minMoves = new MinimumKnightMoves_1197();
		System.out.println(minMoves.minKnightMoves(5, 5));
	}

}
