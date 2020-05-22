//https://leetcode.com/problems/fibonacci-number/
public class FibonacciNumber_509 {

	// Iterative
	public int fibItr(int N) {
		int[] arr = new int[N + 1];

		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= N; i++)
			arr[i] = arr[i - 1] + arr[i - 2];

		return arr[N];
	}

	public int fibonacci(int N, int[] dp) {
		if (N < 2) {
			return dp[N];
		}

		if (dp[N] != 0) {
			return dp[N];
		}

		dp[N] = fibonacci(N - 2, dp) + fibonacci(N - 1, dp);

		return dp[N];
	}

	// Approach 2
	public int fib2(int N) {
		int[] dp = new int[N + 1];

		if (N == 0) {
			return 0;
		}

		dp[0] = 0;
		dp[1] = 1;

		return fibonacci(N, dp);
	}

	// Approach 1 Recursion - This way is faster because we are using Memoization
	// here
	public int fib(int N) {

		if (N < 2) {
			return N;
		}

		int arr[] = new int[N + 1];
		arr[0] = 0;
		arr[1] = 1;
		return solBrtFcMemo(N, arr);
	}

	private int solBrtFcMemo(int N, int[] arr) {
		if (N < 2) {
			return arr[N];
		}

		if (arr[N] != 0) {
			return arr[N];
		}
		int first = solBrtFcMemo(N - 1, arr);
		int second = solBrtFcMemo(N - 2, arr);

		arr[N] = first + second;

		return arr[N];
	}

	public static void main(String[] args) {
		FibonacciNumber_509 num = new FibonacciNumber_509();
		System.out.println(num.fibItr(4));
	}

}
