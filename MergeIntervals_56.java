import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/

public class MergeIntervals_56 {

	public int[][] merge(int[][] intervals) {
		if (intervals.length < 2)
			return intervals;

		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		List<int[]> list = new ArrayList<int[]>();

		list.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			int[] top = list.get(list.size() - 1);
			if (intervals[i][0] <= top[1]) {
				top[1] = Math.max(top[1], intervals[i][1]);
			} else {
				list.add(intervals[i]);
			}
		}
		return list.toArray(new int[list.size()][2]);
	}

	public static void main(String[] args) {
		MergeIntervals_56 merge = new MergeIntervals_56();

		//int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] intervals = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
		//int[][] intervals = {{1,4},{4,5}};
		
		merge.merge(intervals);
	}

}
