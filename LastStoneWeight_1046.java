import java.util.PriorityQueue;

public class LastStoneWeight_1046 {

	public int lastStoneWeight(int[] stones) {

		if (stones.length == 0)
			return 0;
		if (stones.length == 1)
			return stones[0];

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

		for (int i : stones) {
			pq.add(i);
		}

		while (pq.size() > 1) {
			int x = pq.poll();
			int y = pq.poll();

			int temp = x - y;
			if (temp > 0) {
				pq.add(temp);
			}
		}
		return pq.isEmpty() ? 0 : pq.poll();
	}

	public static void main(String[] args) {
		LastStoneWeight_1046 weight = new LastStoneWeight_1046();
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		System.out.println(weight.lastStoneWeight(stones));
	}

}
