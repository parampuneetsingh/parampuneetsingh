import java.util.HashMap;

//https://leetcode.com/problems/find-and-replace-in-string/

public class FindAndReplaceInString_833 {

	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < indexes.length; i++) {
			map.put(indexes[i], i);
		}
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < S.length()) {
			if (map.containsKey(i)) {
				int l = map.get(i);
				String s = S.substring(indexes[l], indexes[l] + sources[l].length());
				if (s.equals(sources[l])) {
					sb.append(targets[l]);
					i += sources[l].length();
					continue;
				}
			}
			sb.append(S.charAt(i++));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		FindAndReplaceInString_833 replace = new FindAndReplaceInString_833();
		/*
		 * String S = "abcd"; int[] indexes = { 0, 2 }; String[] sources = { "a", "cd"
		 * }, targets = { "eee", "ffff" };
		 */
		String S = "vmokgggqzp";
		int[] indexes = { 3, 5, 1 };
		String[] sources = { "kg", "ggq", "mo" }, targets = { "s", "so", "bfr" };
		System.out.println(replace.findReplaceString(S, indexes, sources, targets));
	}
}
