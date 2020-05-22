import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SentenceSimilarityII_737 {

	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		HashMap<String, Set<String>> map = new HashMap<String, Set<String>>();

		if (words1.length != words2.length) {
			return false;
		}

		for (String[] str : pairs) {
			String s1 = str[0], s2 = str[1];
			/*if (!map.containsKey(s1)) {
				map.put(s1, new HashSet<String>());
			}
			
			if (!map.containsKey(s2)) {
				map.put(s2, new HashSet<String>());
			}
			*/
			map.put(s1, new HashSet<String>());
			map.put(s2, new HashSet<String>());
			
			map.get(s1).add(s2);
			map.get(s2).add(s1);
		}

		for (int i = 0; i < words1.length; i++) {
			String w1 = words1[i], w2 = words2[i];

			if (!(w1.equals(w2) || map.get(w1).equals(map.get(w2)) || map.get(w1).contains(w2)
					|| map.get(w2).contains(w1))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String[] words1 = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		String[][] pairs = { { "great", "good" }, { "fine", "good" }, { "acting", "drama" }, { "skills", "talent" } };

		System.out.println(areSentencesSimilar(words1, words2, pairs));
	}

}
