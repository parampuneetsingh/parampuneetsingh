import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstUniqueNumber {

	LinkedHashMap<Integer, Integer> map;

	public FirstUniqueNumber(int[] nums) {
		map = new LinkedHashMap<Integer, Integer>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
	}

	public int showFirstUnique() {
		int peek = -1;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				peek = entry.getKey();
				break;
			}
		}
		return peek;
	}

	public void add(int value) {
		map.put(value, map.getOrDefault(value, 0) + 1);
	}

	public static void main(String[] args) {
		int[] nums = { 233 };
		FirstUniqueNumber unique = new FirstUniqueNumber(nums);

		System.out.println(unique.showFirstUnique());
		unique.add(11);
		System.out.println(unique.showFirstUnique());

	}

}
