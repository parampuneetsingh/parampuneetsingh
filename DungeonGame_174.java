import java.util.Arrays;

//https://leetcode.com/problems/dungeon-game/
//https://www.youtube.com/watch?v=LbC0ejgACkE

public class DungeonGame_174 {

	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length, n = dungeon[0].length;
		int[][] dp = new int[m + 1][n + 1];

		for (int k = 0; k <= m; k++) {
			Arrays.fill(dp[k], Integer.MAX_VALUE);
		}

		dp[m][n - 1] = 1;
		dp[m - 1][n] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
			}
		}

		return dp[0][0];
	}
	
/*	
	{ -2, -3, 3 }, 
	{ -5, -10, 1 }, 
	{ 10, 30, -5 }
		
		|
		v
		
	[[7, 5, 2, INF], 
	 [6, 11, 5, INF], 
	 [1, 1, 6, 1], 
	 [INF, INF, 1, INF]]
*/

	public static void main(String[] args) {
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(dungeon));
	}

}
