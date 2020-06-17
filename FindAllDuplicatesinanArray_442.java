import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/
//https://www.youtube.com/watch?v=jZzVUktAxU4

public class FindAllDuplicatesinanArray_442 {

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;

			if (nums[idx] < 0) {
				list.add(Math.abs(nums[i]));
			} else {
				nums[idx] = -nums[idx];
			}
		}

		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 2, 5, 10, 9, 1, 1, 4, 3, 7 };

		System.out.println(findDuplicates(nums));
	}

}
