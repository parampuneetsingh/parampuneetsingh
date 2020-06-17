import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/top-k-frequent-elements/

public class TopKFrequentElements_347 {

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[k];

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Integer> list = new ArrayList<Integer>(map.keySet());

		Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

		int counter = 0;

		while (counter < k) {
			res[counter] = list.get(counter);
			counter++;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		topKFrequent(nums, k);
	}

}
