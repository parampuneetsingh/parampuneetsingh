
//https://leetcode.com/problems/k-closest-points-to-origin/
import java.util.PriorityQueue;

public class NearestPoints_973 {

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
				(a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

		for (int[] i : points)
			maxHeap.add(i);
		if (maxHeap.size() > k) {
			maxHeap.remove();
		}

		int[][] result = new int[k][2];
		while (k-- > 0) {
			result[k] = maxHeap.remove();
		}
		return result;
	}

	public static void main(String[] args) {
		NearestPoints_973 np = new NearestPoints_973();
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;
		np.kClosest(points, k);
	}
}