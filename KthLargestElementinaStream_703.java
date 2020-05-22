import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElementinaStream_703 {

	PriorityQueue<Integer> minHeap;
	int k;

	public KthLargestElementinaStream_703(int k, int[] nums) {
		this.k = k;

		minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}
	}

	public int add(int val) {
		minHeap.add(val);

		while (minHeap.size() > k) {
			minHeap.poll();
		}

		return minHeap.peek();
	}

	public static void main(String[] args) {
		int k = 3;
		int[] arr = { 4, 5, 8, 2 };
		KthLargestElementinaStream_703 kthLargest = new KthLargestElementinaStream_703(k, arr);
		kthLargest.add(3); // returns 4
		kthLargest.add(5); // returns 5
		kthLargest.add(10); // returns 5
		kthLargest.add(9); // returns 8
		kthLargest.add(4); // returns 8
	}

}
