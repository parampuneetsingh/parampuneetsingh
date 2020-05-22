import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
//https://www.youtube.com/watch?v=rmscV-OsLNQ

public class LongestConsecutiveSequence_128 {

	public static int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		int max = 0;

		for (int i : nums) {
			set.add(i);
		}

		for (int n : nums) {
			if (!set.contains(n - 1)) {
				int j = n;
				while (set.contains(j)) {
					j++;
				}
				max = Math.max(max, j - n);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(nums));
	}

}
