import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/sort-characters-by-frequency/

public class SortCharactersByFrequency_451 {

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		List<Character> list = new ArrayList<Character>();
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		list.addAll(map.keySet());

		Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

		for (char c : list) {
			for (int i = 0; i < map.get(c); i++) {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "tree";
		System.out.println(frequencySort(s));
	}

}
