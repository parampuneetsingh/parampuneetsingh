import java.util.ArrayList;
import java.util.List;

//https://www.lintcode.com/problem/missing-ranges/

public class MissingRanges_163 {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<String>();
		long next = lower;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < next) {
				continue;
			}

			if (nums[i] == next) {
				next++;
				continue;
			}

			list.add(getRange(next, ((long) nums[i]) - 1));

			next = ((long) nums[i]) + 1;
		}

		if (next <= upper) {
			list.add(getRange(next, (long) upper));
		}

		return list;
	}

	private String getRange(long down, long up) {
		return up == down ? String.valueOf(up) : String.format("%d->%d", down, up);
	}

	public static void main(String[] args) {
		MissingRanges_163 range = new MissingRanges_163();
		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0, upper = 99;
		System.out.println(range.findMissingRanges(nums, lower, upper));
	}

}
