public class DecodeWays_91 {

	// https://www.youtube.com/watch?v=cQX3yHS0cLo
	// https://leetcode.com/problems/decode-ways/

	public int decodeSolution(String s) {
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i <= s.length(); i++) {
			/*
			 * int oneDigit = Integer.valueOf(s.substring(i - 1), i); 
			 * int twoDigit = Integer.valueOf(s.substring(i - 2), i);
			 */

			int oneDigit = Integer.parseInt(s.substring(i - 1, i));
			int twoDigit = Integer.parseInt(s.substring(i - 2, i));

			if (oneDigit >= 1) {
				dp[i] += dp[i - 1];
			}

			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		DecodeWays_91 decode = new DecodeWays_91();
		String number = "226";
		System.out.println(decode.decodeSolution(number));
		System.out.println((-1) - (-3));
	}

}
