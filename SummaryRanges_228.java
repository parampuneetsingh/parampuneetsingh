import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/summary-ranges/

public class SummaryRanges_228 {

	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();

		if (nums.length == 0) {
			return list;
		}

		int idx = 1;
		int top = nums[0];

		while (idx < nums.length) {
			if (nums[idx] != nums[idx - 1] + 1) {
				if (top == nums[idx - 1]) {
					list.add(String.valueOf(top));
				} else {
					list.add(top + "->" + nums[idx - 1]);
				}
				top = nums[idx];
			}
			idx++;
		}

		if (top == nums[idx - 1]) {
			list.add(String.valueOf(top));
		} else {
			list.add(top + "->" + nums[idx - 1]);
		}

		return list;
	}

	public static void main(String[] args) {
		SummaryRanges_228 ranges = new SummaryRanges_228();
		int[] nums = { 0, 1, 2, 4, 5, 7 };
		System.out.println(ranges.summaryRanges(nums).toString());
	}

}
