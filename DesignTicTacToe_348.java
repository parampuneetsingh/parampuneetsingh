//https://zhuhan0.blogspot.com/2017/10/leetcode-348-design-tic-tac-toe.html

public class DesignTicTacToe_348 {

	private int[] rows;
	private int[] cols;
	private int diagonal1;
	private int diagonal2;

	/** Initialize your data structure here. */
	public DesignTicTacToe_348(int n) {
		rows = new int[n];
		cols = new int[n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		int n = rows.length;
		int move = player == 1 ? 1 : -1;
		rows[row] += move;
		cols[col] += move;

		if (row == col) {
			diagonal1 += move;
		}
		if (row + col == n - 1) {
			diagonal2 += move;
		}

		if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal1) == n
				|| Math.abs(diagonal2) == n) {
			return player;
		}
		return 0;
	}

	public static void main(String[] args) {
		//Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

		DesignTicTacToe_348 toe = new DesignTicTacToe_348(3);
		toe.move(0, 0, 1); //-> Returns 0 (no one wins)
			/*
				|X| | |
				| | | |    // Player 1 makes a move at (0, 0).
				| | | |
			 */
		toe.move(0, 2, 2); //-> Returns 0 (no one wins)
		/*
				|X| |O|
				| | | |    // Player 2 makes a move at (0, 2).
				| | | |
		 */
		toe.move(2, 2, 1); //-> Returns 0 (no one wins)
		/*		
				|X| |O|
				| | | |    // Player 1 makes a move at (2, 2).
				| | |X|
		 */
		toe.move(1, 1, 2); //-> Returns 0 (no one wins)
		/*
				|X| |O|
				| |O| |    // Player 2 makes a move at (1, 1).
				| | |X|
		*/
		toe.move(2, 0, 1); //-> Returns 0 (no one wins)
		/*		
				|X| |O|
				| |O| |    // Player 1 makes a move at (2, 0).
				|X| |X|
		 */
		toe.move(1, 0, 2); //-> Returns 0 (no one wins)
		/*
				|X| |O|
				|O|O| |    // Player 2 makes a move at (1, 0).
				|X| |X|
		*/
		toe.move(2, 1, 1); //-> Returns 1 (player 1 wins)
		/*
		 		|X| |O|
				|O|O| |    // Player 1 makes a move at (2, 1).
				|X|X|X|
		*/
	}

}
