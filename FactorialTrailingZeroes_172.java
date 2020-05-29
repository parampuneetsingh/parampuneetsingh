//https://leetcode.com/problems/factorial-trailing-zeroes/
//https://leetcode.com/problems/factorial-trailing-zeroes/discuss/656339/Java-0ms-Solution

public class FactorialTrailingZeroes_172 {

	public static int trailingZeroes(int n) {
		int res = 0;
		while (n / 5 != 0) {
			n = n / 5;
			res += n;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(trailingZeroes(n));
	}

}
