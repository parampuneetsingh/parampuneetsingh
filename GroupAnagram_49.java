import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram_49 {

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return new ArrayList();
		Map<String, ArrayList> ans = new HashMap<String, ArrayList>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}

	public List<List<String>> groupAnagram(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		int[] charAry;
		StringBuilder sb;

		for (String s : strs) {
			charAry = new int[26];
			sb = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				charAry[s.charAt(i) - 'a']++;
			}

			for (int c : charAry) {
				sb.append(c);
			}

			String key = sb.toString();

			List<String> l = map.getOrDefault(key, new ArrayList<String>());
			l.add(s);
			map.put(key, l);
		}

		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagram_49 anagram = new GroupAnagram_49();
		List<List<String>> resp = anagram.groupAnagram(strs);
		System.out.println(resp);

	}

}
