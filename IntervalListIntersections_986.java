import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {

	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		int i = 0, j = 0;
		List<int[]> lst = new ArrayList<int[]>();

		while (i < A.length && j < B.length) {
			int low = Math.max(A[i][0], B[j][0]);
			int high = Math.min(A[i][1], B[j][1]);

			if (low <= high) {
				lst.add(new int[] { low, high });
			}

			if (A[i][1] < B[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		return lst.toArray(new int[lst.size()][]);
	}

	public static void main(String[] args) {
		int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
				B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		intervalIntersection(A, B);
	}

}
