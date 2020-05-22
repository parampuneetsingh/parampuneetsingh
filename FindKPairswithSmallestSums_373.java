import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
public class FindKPairswithSmallestSums_373 {

	public void addElements(int[] nums1, int[] nums2, PriorityQueue<int[]> pq) {
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				pq.add(new int[] { nums1[i], nums2[j] });
			}
		}
	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> ((a[0] + a[1]) - (b[0] + b[1])));
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		addElements(nums1, nums2, pq);

		int index = 0;
		while (index < k && pq.size() > 0) {
			int[] queueVal = pq.poll();

			if (list.size() <= index) {
				list.add(index, new ArrayList<Integer>());
			}

			list.get(index).add(queueVal[0]);
			list.get(index).add(queueVal[1]);

			index++;
		}

		return list;
	}

	public static void main(String[] args) {
		FindKPairswithSmallestSums_373 pairs = new FindKPairswithSmallestSums_373();
		int[] nums1 = { 1, 7, 11 }, nums2 = { 2, 4, 6 };
		int k = 3;
		System.out.println(pairs.kSmallestPairs(nums1, nums2, k));
	}

}
