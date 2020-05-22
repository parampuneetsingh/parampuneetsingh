//https://leetcode.com/problems/word-search/
//https://www.youtube.com/watch?v=vYYNp0Jrdv0

public class WordSearch_79 {

public boolean exist(char[][] board, String word) {
        
        for (int i=0;i<board.length;i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && wordSearch(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean wordSearch(char[][] board, String word, int count, int i, int j) {
        
        if (count == word.length()) {
            return true;
        }
        
        if (i <0 || i >= board.length || j<0 || j >=board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean resp = wordSearch(board, word, count+1, i-1, j) || wordSearch(board, word, count+1, i+1, j) || wordSearch(board, word, count+1, i, j-1) || wordSearch(board, word, count+1, i, j+1);
        
        board[i][j] = temp;
        
        return resp;
    }
    
	public static void main(String[] args) {
		WordSearch_79 search = new WordSearch_79();
		char[][] board = {
		                  {'A','B','C','E'},
		                  {'S','F','C','S'},
		                  {'A','D','E','E'}
		                  };
		String word = "ABCCED";
		boolean resp = search.exist(board, word);
		System.out.println(resp);
	}

}
