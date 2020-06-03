import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-maximum/

public class SlidingWindowMaximum_239 {

	//Solution in Linear time
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

	public int[] maxSlidingWindow2(int[] nums, int k) {
		int[] output = new int[nums.length + 1 - k];

		if (nums == null || nums.length == 0 && k == 0) {
			return new int[0];
		}

		int start = 0, end = k - 1;

		while (end < nums.length) {
			int max = Integer.MIN_VALUE;

			for (int i = start; i <= end; i++) {
				max = Math.max(max, nums[i]);
			}
			output[start] = max;
			start++;
			end++;
		}
		return output;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		maxSlidingWindow(nums, k);
	}

}
