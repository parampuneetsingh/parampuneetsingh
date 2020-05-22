import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.lintcode.com/problem/split-array-with-equal-sum/description

public class SplitArrayWithEqualSum_548 {

	public static boolean splitArray(List<Integer> nums) {
		// Partitions should be possible
		if (nums == null || nums.size() < 7) {
			return false;
		}

		int[] prefix = new int[nums.size()];

		prefix[0] = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			prefix[i] = nums.get(i) + prefix[i - 1];
		}

		// End at len - 3, ensure at least one element between j, and k
		for (int j = 3; j < prefix.length - 3; j++) {
			// Save equal partitions for 1st half
			// Restart for each j
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 1; i < j - 1; i++) {
				int a = prefix[i - 1];
				int b = prefix[j - 1] - prefix[i];

				if (a == b) {
					set.add(a);
				}
			}

			// See if partition in 2nd half has same sum
			// Start at j + 2, to ensure atleast one element between j, and k
			for (int k = j + 2; k < prefix.length - 1; k++) {
				int c = prefix[k - 1] - prefix[j];
				int d = prefix[prefix.length - 1] - prefix[k];

				if (c == d && set.contains(c)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] n = { 1, 3, 2, 1, 3, 2, 1, 3, 2, 1, 3 };
		List<Integer> list = new ArrayList<Integer>();
		for (int i : n) {
			list.add(i);
		}

		System.out.println(splitArray(list));
	}

}
