//https://leetcode.com/problems/maximum-swap/

public class MaximumSwap_670 {

	public static int maximumSwap(int num) {
		char[] digits = Integer.toString(num).toCharArray();

		for (int i = 1; i < digits.length; i++) {
			if (digits[i] > digits[i - 1]) {
				int minLeft = i - 1;
				int maxRight = i;

				while (i < digits.length) {
					if (digits[i] >= digits[maxRight]) {
						maxRight = i;
					}

					i++;
				}

				while (minLeft > 0 && digits[minLeft - 1] < digits[maxRight]) {
					minLeft--;
				}

				char c = digits[minLeft];
				digits[minLeft] = digits[maxRight];
				digits[maxRight] = c;

				break;
			}
		}

		int res = 0;
		for (char d : digits) {
			res = res * 10 + (d - '0');
		}

		return res;
	}

	public static void main(String[] args) {
		int num = 2736;
		System.out.println(maximumSwap(num));
	}

}
