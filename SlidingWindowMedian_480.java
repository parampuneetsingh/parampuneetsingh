import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/sliding-window-median/

//Not an accepted solution
public class SlidingWindowMedian_480 {

	public double findMedian(int[] nums) {
		int i = 0, j = nums.length - 1;
		int mid = (i + j) / 2;
		double res;

		Arrays.sort(nums);

		if (nums.length % 2 == 0) {
			res = (nums[mid] + nums[mid + 1]) / 2;
		} else {
			res = nums[mid];
		}

		return res;
	}

	public double[] medianSlidingWindow(int[] nums, int k) {
		int left = 0, right = k;
		int n = nums.length;
		List<Double> list = new ArrayList<Double>();

		while (left < n && right <= n) {
			list.add(findMedian(Arrays.copyOfRange(nums, left, right)));
			left++;
			right++;
		}

		double[] res = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}

		return res;
	}

	public static void main(String[] args) {
		SlidingWindowMedian_480 median = new SlidingWindowMedian_480();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		median.medianSlidingWindow(nums, k);
	}

}
