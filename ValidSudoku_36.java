public class ValidSudoku_36 {

	public static boolean isValidSudoku(char[][] board) {
		boolean[][] block = null;
		for (int r = 0; r < board.length; r++) {
			boolean[] row = new boolean[9];
			boolean[] col = new boolean[9];
			if (r % 3 == 0) {
				block = new boolean[3][9];
			}

			for (int c = 0; c < 9; c++) {
				// Check row wise
				char cell = board[r][c];
				if (cell != '.') {
					if (row[cell - '1'] == true) {
						return false;
					} else {
						row[cell - '1'] = true;
					}

					// Check block wise
					int b = c / 3;
					if (block[b][cell - '1'] == true) {
						return false;
					} else {
						block[b][cell - '1'] = true;
					}
				}

				// Check column wise
				cell = board[c][r];
				if (cell != '.') {
					if (col[cell - '1'] == true) {
						return false;
					} else {
						col[cell - '1'] = true;
					}
				}
			}

		}
		return true;
	}

	public static void main(String[] args) {
		char[][] nums = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(nums));

	}

}
