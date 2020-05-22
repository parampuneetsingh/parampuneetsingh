import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-search-ii/

public class WordSearchII_212 {

	/*
	public boolean dfs(char[][] board, int i, int j, String word, int counter) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(counter)) {
			return false;
		}

		if (counter == word.length() - 1) {
			return true;
		}

		char t = board[i][j];
		board[i][j] = ' ';
		boolean resp = dfs(board, i - 1, j, word, counter + 1) || dfs(board, i + 1, j, word, counter + 1)
				|| dfs(board, i, j - 1, word, counter + 1) || dfs(board, i, j + 1, word, counter + 1);

		board[i][j] = t;

		return resp;
	}

	public void iterateBoard(char[][] board, String word, HashSet<String> sets) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
					sets.add(word);
				}
			}
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		HashSet<String> sets = new HashSet<String>();

		for (String word : words) {
			iterateBoard(board, word, sets);
		}

		return new ArrayList<>(sets);
	}*/
	
    TrieNode root;
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        String word;
        
        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.endOfWord = endOfWord;
            this.word = word;
        }
    }
    
    public WordSearchII_212() {
        root = new TrieNode();
    }
    
    public void insertIntoTrie(String word) {
        TrieNode curr = root;
        
        for(char c:word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
        curr.word = word;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode node, HashSet<String> sets) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || !node.children.containsKey(board[i][j])) {
            return;
        }
        
        char c = board[i][j];
        board[i][j] = ' ';
        
        node = node.children.get(c);
        
        if (node.endOfWord) {
            sets.add(node.word);
        }
        
        dfs(board, i-1, j, node, sets);
        dfs(board, i+1, j, node, sets);
        dfs(board, i, j-1, node, sets);
        dfs(board, i, j+1, node, sets);
        
        board[i][j] = c;
    }
    
    //Trie Solution is Much Faster than the above one
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> sets = new HashSet<String>();
        
        for(String word: words) {
            insertIntoTrie(word);
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, root, sets);
            }
        }
        
        return new ArrayList<>(sets);
    }

	public static void main(String[] args) {
		WordSearchII_212 search = new WordSearchII_212();
		char[][] board = {
				  {'o','a','a','n'},
				  {'e','t','a','e'},
				  {'i','h','k','r'},
				  {'i','f','l','v'}
				};
		
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(search.findWords(board, words));
		
	}

}
