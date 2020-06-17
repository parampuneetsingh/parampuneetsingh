import java.util.Arrays;

//https://leetcode.com/problems/perfect-squares/
//https://www.youtube.com/watch?v=KaXeidsmvVQ

public class PerfectSquares_279 {

	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n);
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (i - j * j >= 0)
					dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int n = 12;
		// int n = 13;
		System.out.println(numSquares(n));
	}

}
