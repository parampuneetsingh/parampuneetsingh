import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
//https://www.programcreek.com/2012/12/leetcode-insert-interval/
//https://leetcode.com/problems/insert-interval/discuss/278014/Java-solution-for-New-Input-Type

public class InsertInterval_57 {

	//Solution 2
	public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<int[]>();
        
        for(int[] interval:intervals) {
            if (interval[1] < newInterval[0]) {
                list.add(interval);
            } 
            else if (interval[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = interval;
            }
            else if (interval[1] >= newInterval[0] || interval[0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        list.add(newInterval);
        
        return list.toArray(new int[list.size()][2]);
    }
	
	//Solution 1
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> res = new ArrayList<int[]>();

		int n = intervals.length;
		int start = newInterval[0];
		int end = newInterval[1];

		int i = 0;
		// add ends time < start;
		while (i < n && intervals[i][1] < start) {
			res.add(intervals[i]);
			i++;
		}

		// merge starts time <= end
		while (i < n && intervals[i][0] <= end) {
			start = Math.min(start, intervals[i][0]);
			end = Math.max(end, intervals[i][1]);
			i++;
		}
		res.add(new int[] { start, end });

		while (i < n) {
			res.add(intervals[i]);
			i++;
		}
		return res.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		InsertInterval_57 insert = new InsertInterval_57();
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };
		int[][] res = insert.insert(intervals, newInterval);

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.println(res[i][j]);
			}
			System.out.println("\n");
		}
	}
}
