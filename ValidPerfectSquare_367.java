//https://leetcode.com/problems/valid-perfect-square/
//https://www.youtube.com/watch?v=Dym8_DkOWL4

public class ValidPerfectSquare_367 {

	//Math Approach
	public boolean isPerfectSquare(int num) {
	     int i = 1;
	     while (num > 0) {
	         num -= i;
	         i += 2;
	     }
	     return num == 0;
	 }
	
	//Newton Method or Bitwise Approach
	public boolean isPerfectSquare1(int num) {
		long x = num;
		while (x * x > num) {
			x = (x + num / x) >> 1;
		}
		return x * x == num;
	}

	public boolean isPerfectSquare2(int num) {
		int lastDigit = num % 10;

		if (lastDigit == 2 || lastDigit == 3 || lastDigit == 7 || lastDigit == 8) {
			return false;
		}

		int low = 1, high = num;
		long mid;

		while (low <= high) {
			mid = low + (high - low) / 2;
			long n = mid * mid;
			if (n == num) {
				return true;
			} else if (n > num) {
				high = (int) mid - 1;
			} else {
				low = (int) mid + 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		ValidPerfectSquare_367 valid = new ValidPerfectSquare_367();
		int num = 14;
		// int num = 808201;
		System.out.println(valid.isPerfectSquare(num));

	}

}
