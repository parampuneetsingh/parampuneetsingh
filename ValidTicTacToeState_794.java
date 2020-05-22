//https://leetcode.com/problems/valid-tic-tac-toe-state

public class ValidTicTacToeState_794 {

	public boolean validTicTacToe(String[] board) {
		int cntx = getCnt(board, 'X');
		int cnto = getCnt(board, 'O');
		if (cntx != cnto && cntx != cnto + 1)
			return false;
		if (win(board, 'X') && win(board, 'O'))
			return false;
		if (win(board, 'X') && cntx == cnto)
			return false;
		if (win(board, 'O') && cntx == cnto + 1)
			return false;
		return true;
	}

	public boolean win(String[] board, char c) {
		String end = "" + c + c + c;
		
		//Validate Row
		for (String s : board) {
			if (s.equals(end))
				return true;
		}
		
		//Validate Column
		for (int i = 0; i < board.length; i++) {
			String t = "";
			for (int j = 0; j < board.length; j++) {
				t += board[j].charAt(i);
			}
			if (t.equals(end))
				return true;
		}
		
		//Validate Diagonal
		String a = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
		String b = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);
		if (a.equals(end) || b.equals(end))
			return true;
		
		return false;
	}

	public int getCnt(String[] board, char c) {
		int cnt = 0;
		for (String s : board) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == c)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
