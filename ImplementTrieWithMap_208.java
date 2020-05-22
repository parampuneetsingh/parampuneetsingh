import java.util.HashMap;
import java.util.Map;

public class ImplementTrieWithMap_208 {

	static TrieNode root;

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
	}

	/** Initialize your data structure here. */
	public ImplementTrieWithMap_208() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			if (!curr.children.containsKey(word.charAt(i))) {
				curr.children.put(word.charAt(i), new TrieNode());
			}
			curr = curr.children.get(word.charAt(i));

		}
		curr.endOfWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (!curr.children.containsKey(word.charAt(i))) {
				return false;
			} else {
				curr = curr.children.get(word.charAt(i));
			}

		}
		return curr.endOfWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String word) {
		TrieNode curr = root;
		int i;
		for (i = 0; i < word.length(); i++) {
			if (!curr.children.containsKey(word.charAt(i))) {
				return false;
			} else {
				curr = curr.children.get(word.charAt(i));
			}

		}
		return word.length() == i;
	}

	public void printTrie(String s, TrieNode root) {
		if (root.endOfWord) {
			System.out.println(s);
		}
		if (root.children.size() > 0) {
			for (Character c : root.children.keySet()) {
				printTrie(s + c, root.children.get(c));
			}
		}

	}
	
	public void printTrie2(String s, String op, TrieNode root) {
		if (root.endOfWord) {
			System.out.println(op);
		}
		if (root.children.size() > 0) {
			for (Character c : root.children.keySet()) {
				printTrie2(s, op + c, root.children.get(c));
			}
		}

	}

	public static void main(String[] args) {
		ImplementTrieWithMap_208 trie = new ImplementTrieWithMap_208();

		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
		//Print Trie
		trie.printTrie2("apple", "", root);
	}

}