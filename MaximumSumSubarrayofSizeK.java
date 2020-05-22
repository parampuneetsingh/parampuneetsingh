//https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP

public class MaximumSumSubarrayofSizeK {

	// Solution1
	public static int findMaxSumSubArray(int k, int[] arr) {
		int[] dp = new int[arr.length + 1];
		for (int i = 1; i < arr.length; i++) {
			dp[i] = dp[i - 1] + arr[i - 1];
		}

		int j = 0;
		int max = 0;
		while (j < arr.length - k) {
			int t = dp[j + k] - dp[j];
			max = Math.max(max, t);
			j++;
		}

		return max;
	}

	// Solution2 Brute Force
	public static int findMaxSumSubArray2(int k, int[] arr) {
		int maxSum = 0, windowSum;
		for (int i = 0; i <= arr.length - k; i++) {
			windowSum = 0;
			for (int j = i; j < i + k; j++) {
				windowSum += arr[j];
			}
			maxSum = Math.max(maxSum, windowSum);
		}

		return maxSum;
	}

	// Solution3 Brute Force
	public static int findMaxSumSubArray3(int k, int[] arr) {
		int windowSum = 0, maxSum = 0;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd]; // add the next element
			// slide the window, we don't need to slide if we've not hit the required window
			// size of 'k'
			if (windowEnd >= k - 1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= arr[windowStart]; // subtract the element going out
				windowStart++; // slide the window ahead
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, -1, -2, 7, 3, -1, 2 };
		int k = 4;
		System.out.println(findMaxSumSubArray3(k, arr));
	}

}
