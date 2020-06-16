import java.util.PriorityQueue;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/
//https://www.youtube.com/watch?v=H8EeY58LLz0

public class CheapestFlightsWithinKStops_787 {

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[][] g = new int[n][n];
		for (int[] f : flights) {
			g[f[0]][f[1]] = f[2];
		}

		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		heap.offer(new int[] { 0, src, K + 1 });

		while (!heap.isEmpty()) {
			int[] cur = heap.poll();
			int price = cur[0], place = cur[1], remainStops = cur[2];

			if (place == dst)
				return price;

			if (remainStops > 0) {
				for (int i = 0; i < n; i++) {
					if (g[place][i] > 0) {
						heap.offer(new int[] { price + g[place][i], i, remainStops - 1 });
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int n = 3, src = 0, dst = 2, k = 1;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		System.out.println(findCheapestPrice(n, flights, src, dst, k));
	}

}
