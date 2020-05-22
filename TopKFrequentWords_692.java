import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-words/

public class TopKFrequentWords_692 {

	// Solution1 - Better and Easy
	public List<String> topKFrequent2(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		List<String> candidates = new ArrayList<String>(map.keySet());

		Collections.sort(candidates,
				(a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));

		return candidates.subList(0, k);
	}

	// Solution2
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> maxHeap = new PriorityQueue<String>(
				(a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b));

		for (String word : map.keySet()) {
			maxHeap.offer(word);
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		List<String> ans = new ArrayList<String>();
		while (!maxHeap.isEmpty())
			ans.add(maxHeap.poll());
		return ans;
	}

	public static void main(String[] args) {
		TopKFrequentWords_692 topK = new TopKFrequentWords_692();
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;
		System.out.println(topK.topKFrequent2(words, k));
	}
}