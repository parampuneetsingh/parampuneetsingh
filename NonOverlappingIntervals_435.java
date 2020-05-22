import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/

public class NonOverlappingIntervals_435 {

	public int eraseOverlapIntervals(int[][] intervals) {
		int count = 0;

		if (intervals.length == 0) {
			return count;
		}

		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

		int[] prev = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < prev[1]) {
				count++;
			} else {
				prev[1] = Math.max(prev[1], intervals[i][1]);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		NonOverlappingIntervals_435 intrvl = new NonOverlappingIntervals_435();
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println(intrvl.eraseOverlapIntervals(intervals));
	}

}
