//https://leetcode.com/problems/coin-change-2/
//https://www.youtube.com/watch?v=Nvrhx4lbfLI

public class CoinChange2_518 {

	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];

		dp[0] = 1;

		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i - coin];
			}
		}

		return dp[amount];
	}

	public static void main(String[] args) {
		CoinChange2_518 combinations = new CoinChange2_518();
		int amount = 5, coins[] = { 1, 2, 5 };
		System.out.println(combinations.change(amount, coins));
	}

}
