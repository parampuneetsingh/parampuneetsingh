//https://leetcode.com/problems/add-binary/

public class AddBinary_67 {

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0) {
				sum = sum + b.charAt(j--) - '0';
			}
			if (i >= 0) {
				sum = sum + a.charAt(i--) - '0';
			}
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

	private String padding(String a, int n) {
		StringBuilder sb = new StringBuilder(a);

		while (n-- > 0) {
			sb.insert(0, '0');
		}

		return sb.toString();
	}

	public String addBinary2(String a, String b) {
		StringBuilder sb = new StringBuilder();

		if (a.length() < b.length()) {
			a = padding(a, b.length() - a.length());
		} else if (b.length() < a.length()) {
			b = padding(b, a.length() - b.length());
		}

		int carry = 0;

		for (int i = a.length() - 1; i >= 0; i--) {
			int x = a.charAt(i) - '0';
			int y = b.charAt(i) - '0';

			sb.insert(0, (x ^ y) ^ carry);
			carry = (x & y) | (x & carry) | (y & carry);
		}

		if (carry == 1) {
			sb.insert(0, carry);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		/*
		 * String a = "123"; String b = "1251";
		 */
		String a = "11";
		String b = "1";
		AddBinary_67 sum = new AddBinary_67();
		String resp = sum.addBinary2(a, b);
		System.out.println(resp);
	}

}
