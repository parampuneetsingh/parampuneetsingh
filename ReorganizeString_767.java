import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reorganize-string/
//https://www.youtube.com/watch?v=zaM_GLLvysw

public class ReorganizeString_767 {
	
	public String reorganizeString(String S) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> map.get(b) - map.get(a));
		StringBuilder sb = new StringBuilder();

		for (char c : S.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		pq.addAll(map.keySet());

		while (pq.size() > 1) {
			char a = pq.poll();
			char b = pq.poll();

			sb.append(a);
			sb.append(b);

			if (map.get(a) > 1) {
				map.put(a, map.get(a) - 1);
				pq.add(a);
			}

			if (map.get(b) > 1) {
				map.put(b, map.get(b) - 1);
				pq.add(b);
			}
		}

		if (!pq.isEmpty()) {
			char temp = pq.poll();

			if (map.get(temp) > 1) {
				return "";
			}
			sb.append(temp);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ReorganizeString_767 shuffle = new ReorganizeString_767();
		String S = "aaabc";
		System.out.println(shuffle.reorganizeString(S));
	}

}
