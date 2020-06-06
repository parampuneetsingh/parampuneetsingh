import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html
//https://www.youtube.com/watch?v=LA0X_N-dEsg

public class AlienDictionary_269 {

	public String alienOeder(String[] words) {
		Map<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();
		int[] indegree = new int[26];
		buildGraph(map, words, indegree);
		return bfsGraph(map, indegree);
	}

	private String bfsGraph(Map<Character, ArrayList<Character>> map, int[] indegree) {
		StringBuilder sb = new StringBuilder();
		Queue<Character> q = new LinkedList<Character>();
		int size = map.size();

		for (char c : map.keySet()) {
			if (indegree[c - 'a'] == 0) {
				q.add(c);
			}
		}

		while (!q.isEmpty()) {
			char temp = q.poll();
			sb.append(temp);

			for (char c : map.get(temp)) {
				indegree[c - 'a']--;
				if (indegree[c - 'a'] == 0) {
					q.add(c);
				}
			}
		}

		return sb.length() != size ? "" : sb.toString();
	}

	private void buildGraph(Map<Character, ArrayList<Character>> map, String[] words, int[] indegree) {
		for (String word : words) {
			for (char c : word.toCharArray()) {
				map.putIfAbsent(c, new ArrayList<Character>());
			}
		}

		for (int i = 1; i < words.length; i++) {
			String first = words[i - 1];
			String second = words[i];
			int len = Math.min(first.length(), second.length());

			for (int j = 0; j < len; j++) {
				if (first.charAt(j) != second.charAt(j)) {
					if (!map.get(first.charAt(j)).contains(second.charAt(j))) {
						map.get(first.charAt(j)).add(second.charAt(j));
						indegree[second.charAt(j) - 'a']++;
					}
					break;
				}
				
				//Optional
				if (j + 1 == len && first.length() > second.length()) {
                    map.clear();
                    return;
                }
			}
		}
	}

	public static void main(String[] args) {
		AlienDictionary_269 order = new AlienDictionary_269();
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println(order.alienOeder(words));
	}

}
