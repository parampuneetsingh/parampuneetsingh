import java.util.HashMap;

//https://leetcode.com/problems/contiguous-array/
//https://www.youtube.com/watch?v=VM5Mh3-UFPg

public class ContiguousArray_525 {

	public int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int maxLength = 0;
		int count = 0;
		map.put(0, -1);

		for (int i = 0; i < nums.length; i++) {
			int temp = (nums[i] == 1) ? 1 : -1;

			count += temp;
			if (map.containsKey(count)) {
				maxLength = Math.max(maxLength, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		ContiguousArray_525 max = new ContiguousArray_525();
		int[] nums = { 0, 1, 0, 0, 0, 0, 1, 0, 1, 0 };
		System.out.println(max.findMaxLength(nums));
	}
}
