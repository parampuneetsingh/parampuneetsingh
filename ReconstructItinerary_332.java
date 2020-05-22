import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reconstruct-itinerary/

public class ReconstructItinerary_332 {

	public static void dfs(HashMap<String, PriorityQueue<String>> map, List<String> resp, String departure) {
		// If destination exists. When arriving the last departure, add it to res
		// directly
		while (map.containsKey(departure) && !map.get(departure).isEmpty()) {
			// get the next destination, departure and iterate
			dfs(map, resp, map.get(departure).poll());
		}
		resp.add(0, departure);
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		List<String> resp = new ArrayList<String>();
		HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();

		for (List<String> str : tickets) {
			String s1 = str.get(0);
			String s2 = str.get(1);

			if (!map.containsKey(s1)) {
				map.put(s1, new PriorityQueue<String>());
			}

			map.get(s1).add(s2);
		}

		dfs(map, resp, "JFK");

		return resp;
	}

	public static void main(String[] args) {
		// String[][] str = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, {
		// "LHR", "SFO" } };
		String[][] str = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		List<List<String>> l = new ArrayList<List<String>>();

		for (String[] s : str) {
			l.add(Arrays.asList(s));
		}

		System.out.println(findItinerary(l).toString());
	}

}
