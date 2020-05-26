import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/majority-element-ii/

public class MajorityElementII_229 {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums.length == 0) {
			return list;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int k = nums.length / 3;

		for (int key : map.keySet()) {
			int val = map.get(key);
			if (val > k) {
				list.add(key);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(majorityElement(nums));
	}

}
