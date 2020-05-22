import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
//Leetcode Solution

public class FindMedianfromDataStream_295 {

	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;

	/** initialize your data structure here. */
	public FindMedianfromDataStream_295() {
		maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		minHeap = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.peek());
		maxHeap.poll();

		if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.peek());
			minHeap.poll();
		}
	}

	public double findMedian() {
		return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (double) (minHeap.peek() + maxHeap.peek()) / 2;
	}

	public static void main(String[] args) {
		FindMedianfromDataStream_295 findMedian = new FindMedianfromDataStream_295();
		findMedian.addNum(1);
		findMedian.addNum(2);
		System.out.println(findMedian.findMedian()); // -> 1.5
		findMedian.addNum(3);
		System.out.println(findMedian.findMedian());
	}

}
