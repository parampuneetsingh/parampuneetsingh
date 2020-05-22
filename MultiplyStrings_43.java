//https://leetcode.com/problems/multiply-strings/

public class MultiplyStrings_43 {

	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int len = len1 + len2;
		int[] result = new int[len];
		StringBuilder sb = new StringBuilder();

		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		// Init the result int array
		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}

		// Iterate the numbers from the reverse & multiply the digits & then sum them up
		for (int i = len1 - 1; i >= 0; i--) {
			int k = --len;
			for (int j = len2 - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int sum = mul + result[k];

				// Mod % gives the remainder / carry
				result[k] = sum % 10;

				// Division gives the quotient
				result[k - 1] = result[k - 1] + (sum / 10);

				k--;
			}
		}

		int counter = 0;
		while (result[counter] == 0) {
			counter++;
		}

		for (int i = counter; i < result.length; i++) {
			sb.append(result[i]);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings_43 multiply = new MultiplyStrings_43();
		String num1 = "123", num2 = "456";
		System.out.println(multiply.multiply(num1, num2));
	}

}
