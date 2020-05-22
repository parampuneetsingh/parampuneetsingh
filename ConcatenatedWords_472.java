import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/concatenated-words/

public class ConcatenatedWords_472 {

	Trie root;

	class Trie {
		Map<Character, Trie> children;
		boolean endOfWord;

		public Trie() {
			endOfWord = false;
			children = new HashMap<Character, Trie>();
		}

	}

	public void insert(Trie curr, String word) {
		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				curr.children.put(c, new Trie());
			}
			curr = curr.children.get(c);
		}
		curr.endOfWord = true;
	}

	public boolean search(Trie curr, String word) {
		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				return false;
			}
			curr = curr.children.get(c);
		}
		return curr.endOfWord;
	}

	public boolean helper(Trie curr, String word, boolean flag) {
		if (word.equals("") && flag)
			return true;
		if (word.equals(""))
			return false;

		for (int i = 0; i < word.length(); i++) {
			String pre = word.substring(0, i + 1);
			if (i == word.length() - 1 && !flag)
				return false;
			if (search(curr, pre)) {
				// flag = true;
				if (helper(curr, word.substring(i + 1), true)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> list = new ArrayList<String>();
		Trie trieNode = new Trie();
		
		if (words.length == 0) {
			return list;
		}

		for (String word : words) {
			insert(trieNode, word);
		}

		for (String word : words) {
			if (helper(trieNode, word, false)) {
				list.add(word);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		ConcatenatedWords_472 findWords = new ConcatenatedWords_472();
		String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		System.out.println(findWords.findAllConcatenatedWordsInADict(words));
	}

}
