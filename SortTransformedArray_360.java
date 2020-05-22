import java.util.PriorityQueue;

//https://www.lintcode.com/problem/sort-transformed-array/

public class SortTransformedArray_360 {

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int[] res = new int[nums.length];
		int i = 0;

		for (int num : nums) {
			int t = (a * num * num) + (b * num) + c;
			minHeap.add(t);
		}

		while (!minHeap.isEmpty()) {
			res[i] = minHeap.poll();
			i++;
		}

		return res;
	}

	public static void main(String[] args) {
		SortTransformedArray_360 quadratic_func = new SortTransformedArray_360();
		int[] nums = { -4, -2, 2, 4 };
		int a = 1, b = 3, c = 5;
		System.out.println(quadratic_func.sortTransformedArray(nums, a, b, c));
	}

}
