//https://leetcode.com/problems/add-and-search-word-data-structure-design/
//https://www.youtube.com/watch?v=neb_2UK5Kuo
//https://www.youtube.com/watch?v=AXjmTQ8LEoI

public class AddandSearchWord_DataStructureDesign_211 {

	TrieNode root;

	class TrieNode {
		TrieNode[] children;
		boolean endOfWord;

		public TrieNode() {
			children = new TrieNode[26];
			endOfWord = false;
		}
	}

	/** Initialize your data structure here. */
	public AddandSearchWord_DataStructureDesign_211() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = (int) (c - 'a');
			if (curr.children[index] == null) {
				curr.children[index] = new TrieNode();
			}
			curr = curr.children[index];
		}
		curr.endOfWord = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return find(word, root, 0);
	}

	public boolean find(String word, TrieNode curr, int index) {
		if (word.length() == index) {
			return curr.endOfWord;
		}

		char c = word.charAt(index);
		if (c == '.') {
			for (int i = 0; i < 26; i++) {
				if (curr.children[i] != null && find(word, curr.children[i], index + 1)) {
					return true;
				}
			}
			return false;
		} else {
			return curr.children[c - 'a'] != null && find(word, curr.children[c - 'a'], index + 1);
		}
	}

	public static void main(String[] args) {
		AddandSearchWord_DataStructureDesign_211 ds = new AddandSearchWord_DataStructureDesign_211();
		ds.addWord("bad");
		ds.addWord("dad");
		ds.addWord("mad");
		ds.search("pad"); // -> false
		ds.search("bad"); // -> true
		ds.search(".ad"); // -> true
		ds.search("b.."); // -> true
	}

}
