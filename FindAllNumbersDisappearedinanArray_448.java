import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//https://www.youtube.com/watch?v=Y5AkrdnUOxs

public class FindAllNumbersDisappearedinanArray_448 {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;

			if (nums[idx] < 0) {
				continue;
			}

			nums[idx] = -nums[idx];
		}

		for (int j = 0; j < nums.length; j++) {
			if (nums[j] > 0) {
				list.add(j + 1);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbers(nums));
	}

}
