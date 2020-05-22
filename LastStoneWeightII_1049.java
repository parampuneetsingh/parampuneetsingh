//https://leetcode.com/problems/last-stone-weight-ii/
//https://www.youtube.com/watch?v=8LusJS5-AGo
//Its a 0-1 Knapsack Problem. Watch Video for Good understanding

public class LastStoneWeightII_1049 {

	public int lastStoneWeightII(int[] stones) {
		if (stones.length == 2)
			return Math.abs(stones[0] - stones[1]);
		int sum = 0;
		for (int n : stones) {
			sum += n;
		}

		int target = sum / 2;

		int[][] dp = new int[stones.length + 1][target + 1];

		//j is weight and i is value
		for (int i = 1; i <= stones.length; i++) {
			for (int j = 1; j <= target; j++) {
				if (j < stones[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(stones[i - 1] + dp[i - 1][j - stones[i - 1]], dp[i - 1][j]);
				}
			}
		}
		return Math.abs(sum - 2 * dp[stones.length][target]);
	}

	public static void main(String[] args) {
		LastStoneWeightII_1049 weight = new LastStoneWeightII_1049();
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		System.out.println(weight.lastStoneWeightII(stones));
	}

}
