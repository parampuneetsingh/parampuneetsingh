import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-maximum/

public class SlidingWindowMaximum_239 {

	// Solution in Linear time
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int l = nums.length;

		if (l == 0)
			return new int[0];

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));

		int[] res = new int[l - k + 1];

		int start = 0, idx = 0;

		for (int i = 0; i < l; i++) {
			maxHeap.add(nums[i]);

			if (maxHeap.size() > k) {
				maxHeap.remove(nums[start++]);
			}

			if (i >= k - 1) {
				res[idx++] = maxHeap.peek();
			}
		}

		return res;
	}

	public static int[] maxSlidingWindow2(int[] nums, int k) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int res[] = new int[nums.length - k + 1];
		int i = 0;
		int index = 0;
		while (i < nums.length) {
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.removeFirst();
			}
			while (!dq.isEmpty() && nums[i] > nums[dq.getLast()])
				dq.removeLast();

			dq.offer(i);
			if (i >= (k - 1))
				res[index++] = nums[dq.peek()];
			i++;

		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		maxSlidingWindow2(nums, k);
	}

}
