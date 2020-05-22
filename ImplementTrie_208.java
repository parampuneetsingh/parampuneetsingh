//https://leetcode.com/problems/implement-trie-prefix-tree/
//https://www.youtube.com/watch?v=neb_2UK5Kuo
//https://www.youtube.com/watch?v=AXjmTQ8LEoI

//Check Leetcode 211 as well. Similar to this problem

public class ImplementTrie_208 {

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
	public ImplementTrie_208() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;

		for (char c : word.toCharArray()) {
			int t = (int) (c - 'a');

			if (curr.children[t] == null) {
				curr.children[t] = new TrieNode();
			}
			curr = curr.children[t];
		}
		curr.endOfWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = find(word, root, 0);
		return node != null && node.endOfWord;
	}

	public TrieNode find(String word, TrieNode curr, int index) {
		if (word.length() == index) {
			return curr;
		}

		char c = word.charAt(index);

		if (curr.children[c - 'a'] == null) {
			return null;
		} else {
			return find(word, curr.children[c - 'a'], index + 1);
		}
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = find(prefix, root, 0);
		return node != null;
	}

	public static void main(String[] args) {
		ImplementTrie_208 trie = new ImplementTrie_208();

		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}

}
