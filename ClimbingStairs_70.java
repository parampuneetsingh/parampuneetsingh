
public class ClimbingStairs_70 {

	//Try this for 1,2,3 steps as well
	//For Climbing 2 stairs
	public int climb2Stairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}

	//Recursive Method
	public int climbStairsRecur(int n) {
		if (n == 0|| n == 1) {
			return n;
		}
		return climbStairsRecur(n-1) + climbStairsRecur(n-2); 
	}
	
	public static void main(String[] args) {
		ClimbingStairs_70 clm = new ClimbingStairs_70();
		int result = clm.climb2Stairs(6);
		//int result = clm.climbStairsRecur(6);
		System.out.println(result);
	}
}
