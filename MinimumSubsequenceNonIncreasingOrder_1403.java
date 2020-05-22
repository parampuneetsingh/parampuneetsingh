import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSubsequenceNonIncreasingOrder_1403 {

	public static List<Integer> minSubsequence(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
		List<Integer> res = new ArrayList<Integer>();

		int total = 0;
		int temp = 0;

		for (int num : nums) {
			total += num;
			pq.add(num);
		}

		while (temp <= total) {
			int t = pq.poll();
			temp += t;
			total -= t;
			res.add(t);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = {4,4,7,6,7};
		System.out.println(minSubsequence(nums));
	}
}
