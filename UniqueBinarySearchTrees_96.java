//https://leetcode.com/problems/unique-binary-search-trees/
//https://www.youtube.com/watch?v=YDf982Lb84o

public class UniqueBinarySearchTrees_96 {

	public int numTrees(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees_96 search = new UniqueBinarySearchTrees_96();
		System.out.println(search.numTrees(3));
	}

}
