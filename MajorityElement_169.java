import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MajorityElement_169 {

	public int majorityElement(int[] nums) {

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(
				new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						return a.compareTo(b);
					}
				});

		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		Map.Entry<Integer, Integer> majorityEntry = null;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (majorityEntry == null
					|| entry.getValue() > majorityEntry.getValue()) {
				majorityEntry = entry;
			}

		}
		return majorityEntry.getKey();
	}

	public static void main(String[] args) {
		MajorityElement_169 element = new MajorityElement_169();
		int[] nums = { 2, 2, 1, 1, 1, 2, 2, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6,
				6, 6, 6, 2, 2, 2, 2 };
		element.majorityElement(nums);
	}
}
