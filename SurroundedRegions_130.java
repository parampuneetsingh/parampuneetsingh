//https://leetcode.com/problems/surrounded-regions/
//https://www.youtube.com/watch?v=xfPyRVGmUy0

public class SurroundedRegions_130 {

	public void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}

		int m = board.length, n = board[0].length;

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < n; i++) {
			if (board[0][i] == 'O') {
				dfs(board, 0, i, visited, false);
			}

			if (board[m - 1][i] == 'O') {
				dfs(board, m - 1, i, visited, false);
			}
		}

		for (int j = 0; j < m; j++) {
			if (board[j][0] == 'O') {
				dfs(board, j, 0, visited, false);
			}

			if (board[j][n - 1] == 'O') {
				dfs(board, j, n - 1, visited, false);
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (board[i][j] == 'O') {
					dfs(board, i, j, visited, true);
				}
			}
		}
	}

	public void dfs(char[][] board, int i, int j, boolean[][] visited, boolean flip) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] || board[i][j] == 'X') {
			return;
		}

		visited[i][j] = true;
		if (flip) {
			board[i][j] = 'X';
		}

		dfs(board, i - 1, j, visited, flip);
		dfs(board, i + 1, j, visited, flip);
		dfs(board, i, j - 1, visited, flip);
		dfs(board, i, j + 1, visited, flip);
	}

	public static void main(String[] args) {
		SurroundedRegions_130 regions = new SurroundedRegions_130();
		char[][] board = { { 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' } };

		regions.solve(board);

	}

}
