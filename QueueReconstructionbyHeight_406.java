import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/queue-reconstruction-by-height/
//https://www.youtube.com/watch?v=_DtZIPUt8jo
//https://www.youtube.com/watch?v=wEEJdHtXEeA

public class QueueReconstructionbyHeight_406 {

	public static int[][] reconstructQueue(int[][] people) {
		List<int[]> resp = new ArrayList<int[]>();
		Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);

		for (int[] x : people) {
			resp.add(x[1], x);
		}

		return resp.toArray(new int[resp.size()][2]);
	}

	public static void main(String[] args) {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		reconstructQueue(people);
	}
}