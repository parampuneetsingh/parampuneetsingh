//https://leetcode.com/problems/battleships-in-a-board/

public class BattleshipsinaBoard_419 {

	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					battleship(board, i, j);
					count++;
				}

			}
		}
		return count;
	}

	public void battleship(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') {
			return;
		}

		board[i][j] = '.';
		battleship(board, i + 1, j);
		battleship(board, i - 1, j);
		battleship(board, i, j + 1);
		battleship(board, i, j - 1);
	}

	// Constant Space
	public int countBattleships2(char[][] board) {
		int count = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X')) {
					while (j < board[0].length && board[i][j] == 'X') {
						j++;
					}

					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		BattleshipsinaBoard_419 battle = new BattleshipsinaBoard_419();
		char[][] board = { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
		int res = battle.countBattleships(board);
		System.out.println(res);
	}

}
