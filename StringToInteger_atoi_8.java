//https://leetcode.com/problems/string-to-integer-atoi/

public class StringToInteger_atoi_8 {

	public int myAtoi(String str) {
		if (str.length() == 0) {
			return 0;
		}

		int idx = 0;
		int n = str.length();
		int flag = 1;
		while (idx < n && str.charAt(idx) == ' ') {
			idx++;
		}

		if (idx < n && (str.charAt(idx) == '-' || str.charAt(idx) == '+')) {
			flag = str.charAt(idx) == '-' ? -1 : 1;
			idx++;
		}

		long num = 0;
		while (idx < n && Character.isDigit(str.charAt(idx))) {
			num = num * 10 + (str.charAt(idx++) - '0');

			if ((flag == 1 && num > Integer.MAX_VALUE) || (-num < Integer.MIN_VALUE)) {
				return getOverflowValue(flag);
			}
		}

		return flag * (int) num;
	}

	private int getOverflowValue(int sign) {
		return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		String str = "2147483646";
		StringToInteger_atoi_8 atoi = new StringToInteger_atoi_8();
		System.out.println(atoi.myAtoi(str));
	}
}
