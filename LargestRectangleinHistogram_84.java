//https://leetcode.com/problems/largest-rectangle-in-histogram/

public class LargestRectangleinHistogram_84 {

	public int largestRectangleArea(int[] arr) {

		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			// get left min
			int l = getLeft(arr, i);

			// get right min
			int r = getRight(arr, i);

			// calc area
			int area = (r + l + 1) * arr[i];

			// update
			if (area > max)
				max = area;
		}

		return max;

	}

	public int getLeft(int[] arr, int i) {
		int step = 0;
		for (int j = i - 1; j >= 0; j--) {
			if (arr[j] < arr[i])
				break;
			else
				step++;
		}
		return step;
	}

	public int getRight(int[] arr, int i) {
		int step = 0;
		for (int j = i + 1; j < arr.length; j++) {
			if (arr[j] < arr[i])
				break;
			else
				step++;
		}
		return step;
	}

	public static void main(String[] args) {
		LargestRectangleinHistogram_84 area = new LargestRectangleinHistogram_84();
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		System.out.println(area.largestRectangleArea(arr));
	}

}
