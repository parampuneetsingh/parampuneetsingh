import java.util.Arrays;

//https://leetcode.com/problems/shortest-bridge/
//https://leetcode.com/problems/shortest-bridge/discuss/667144/Java-DFS-%2B-DFS-%2B-Memo-Solution

public class ShortestBridge_934 {

	int bridgeLength, rows, cols;
	int[][] memo;

	public int shortestBridge(int[][] A) {
		rows = A.length;
		cols = A[0].length;
		bridgeLength = rows + cols;
		boolean isMarked = false;
		memo = new int[rows][cols];
		for (int[] m : memo) {
			Arrays.fill(m, bridgeLength);
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (A[i][j] == 1) {
					if (!isMarked) {
						markIsland(A, i, j);
						isMarked = true;
					} else {
						findBridge(A, i, j, 0);
					}
				}
			}
		}
		return bridgeLength - 1;
	}

	private void markIsland(int[][] A, int i, int j) {
		if (i < 0 || i >= rows || j < 0 || j >= cols) {
			return;
		}
		if (A[i][j] == 1) {
			A[i][j] = 2;
			markIsland(A, i + 1, j);
			markIsland(A, i - 1, j);
			markIsland(A, i, j + 1);
			markIsland(A, i, j - 1);
		}
	}

	private void findBridge(int[][] A, int i, int j, int currentLength) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || currentLength >= memo[i][j]) {
			return;
		}

		memo[i][j] = Math.min(memo[i][j], currentLength);

		if (A[i][j] == 2) {
			bridgeLength = Math.min(currentLength, bridgeLength);
		} else {
			findBridge(A, i + 1, j, currentLength + 1);
			findBridge(A, i - 1, j, currentLength + 1);
			findBridge(A, i, j + 1, currentLength + 1);
			findBridge(A, i, j - 1, currentLength + 1);
		}
	}

	public static void main(String[] args) {
		ShortestBridge_934 shortest = new ShortestBridge_934();
		int[][] A = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
		System.out.println(shortest.shortestBridge(A));
	}

}
