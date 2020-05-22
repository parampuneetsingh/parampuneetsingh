//https://leetcode.com/problems/max-chunks-to-make-sorted/

public class MaxChunksToMakeSorted_769 {

	public static int maxChunksToSorted(int[] arr) {
		int sum = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			if (max == i) {
				sum++;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 3, 4 };
		System.out.println(maxChunksToSorted(arr));
	}

}
