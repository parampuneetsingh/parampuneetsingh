import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/add-and-search-word-data-structure-design/

public class AddandSearchWord_DataStructureDesignWithMap_211 {

	TrieNode root;

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
	}

	/** Initialize your data structure here. */
	public AddandSearchWord_DataStructureDesignWithMap_211() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TrieNode curr = root;

		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				curr.children.put(c, new TrieNode());
			}
			curr = curr.children.get(c);
		}
		curr.endOfWord = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		TrieNode curr = root;

		return searchHelper(word, curr);
	}

	public boolean searchHelper(String word, TrieNode root) {

		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (TrieNode node : curr.children.values()) {
					if (searchHelper(word.substring(i + 1, word.length()), node)) {
						return true;
					}
				}
				return false;
			} else {
				if (!curr.children.containsKey(c)) {
					return false;
				}
				curr = curr.children.get(c);
			}
		}

		return curr.endOfWord;
	}
    
	public static void main(String[] args) {
		AddandSearchWord_DataStructureDesignWithMap_211 ds = new AddandSearchWord_DataStructureDesignWithMap_211();
		/*
		ds.addWord("bad");
		ds.addWord("dad");
		ds.addWord("mad");
		ds.search("pad"); // -> false
		ds.search("bad"); // -> true
		ds.search(".ad"); // -> true
		ds.search("b.."); // -> true
		*/
		ds.addWord("a");
		ds.addWord("a");
		ds.search("."); // -> true
		ds.search("a"); // -> true
		ds.search("aa"); // -> false
		ds.search("a"); // -> true
		ds.search(".a"); // -> false
		ds.search("a."); // -> false
	}

}
