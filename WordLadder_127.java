import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/word-ladder/

public class WordLadder_127 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<String> q = new LinkedList<String>();
		Set<String> sets = new HashSet<String>(wordList);

		if (!wordList.contains(endWord)) {
			return 0;
		}

		q.add(beginWord);
		int length = 1;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int k = 0; k < size; k++) {
				String s = q.poll();

				char[] charAry = s.toCharArray();
				for (int i = 0; i < s.length(); i++) {
					char original_char = charAry[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == original_char)
							continue;
						charAry[i] = c;
						String str = String.valueOf(charAry);

						if (str.equals(endWord)) {
							return length + 1;
						}
						if (sets.contains(str)) {
							q.add(str);
							sets.remove(str);
						}
					}
					charAry[i] = original_char;
				}
			}
			length++;
		}
		return 0;
	}

	public static void main(String[] args) {
		WordLadder_127 findSteps = new WordLadder_127();
		String beginWord = "hit", endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(findSteps.ladderLength(beginWord, endWord, Arrays.asList(wordList)));
	}

}
