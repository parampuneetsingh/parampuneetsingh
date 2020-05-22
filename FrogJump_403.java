import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/frog-jump/
//https://www.youtube.com/watch?v=oTCPG1ezlKc
//http://buttercola.blogspot.com/2018/10/403-frog-jump.html

public class FrogJump_403 {

	public static boolean canCross(int[] stones) {
		List<Integer>[] dp = (List<Integer>[]) new ArrayList[stones.length];
		for (int i = 0; i < stones.length; i++) {
			dp[i] = new ArrayList<>();
		}
		dp[0].add(0);

		for (int i = 1; i < stones.length; i++) {
			for (int j = 0; j < i; j++) {
				for (Integer pos : dp[j]) {
					if (stones[i] >= stones[j] + pos - 1 && stones[i] <= stones[j] + pos + 1) {
						dp[i].add(stones[i] - stones[j]);
						break;
					}
				}
			}
		}

		return !dp[stones.length - 1].isEmpty();
	}

	public static void main(String[] args) {
		int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
		System.out.println(canCross(stones));
	}

}
