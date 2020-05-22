import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/network-delay-time/
//https://www.youtube.com/watch?v=-MsYaftBdkw

public class NetworkDelayTime_743 {

	public int networkDelayTime(int[][] times, int N, int K) {
		HashMap<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

		for (int[] i : times) {
			int a = i[0];
			if (!map.containsKey(a)) {
				map.put(a, new ArrayList<int[]>());
			}
			map.get(a).add(new int[] { i[1], i[2] });
		}

		HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();

		pq.add(new int[] { K, 0 });

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();

			int node = temp[0], d1 = temp[1];

			if (dist.containsKey(node)) {
				continue;
			}

			dist.put(node, d1);

			if (map.containsKey(node)) {
				for (int[] edge : map.get(node)) {
					int n = edge[0], d2 = edge[1];
					if (!dist.containsKey(n)) {
						pq.add(new int[] { n, d1 + d2 });
					}
				}
			}
		}

		if (dist.size() != N)
			return -1;

		int ans = 0;
		for (int cand : dist.values()) {
			ans = Math.max(ans, cand);
		}

		return ans;
	}

	public static void main(String[] args) {
		NetworkDelayTime_743 time = new NetworkDelayTime_743();
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int N = 4, K = 2;
		System.out.println(time.networkDelayTime(times, N, K));
	}

}
