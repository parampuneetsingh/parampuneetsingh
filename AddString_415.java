//https://leetcode.com/problems/add-strings/

public class AddString_415 {

	public static String addStrings(String num1, String num2) {
		int l1 = num1.length() - 1;
		int l2 = num2.length() - 1;
		StringBuilder str = new StringBuilder();
		int carry = 0;

		while (l1 >= 0 || l2 >= 0 || carry > 0) {
			if (l1 >= 0 && l2 >= 0) {
				int temp = num1.charAt(l1) - '0' + (int) num2.charAt(l2) - '0' + carry;
				carry = 0;
				if (temp / 10 > 0) {
					carry = 1;
				}
				str.append(temp % 10);
				l1--;
				l2--;
			}

			else if (l1 >= 0) {
				int temp = num1.charAt(l1) - '0' + carry;
				carry = 0;
				if (temp / 10 > 0) {
					carry = 1;
				}
				l1--;
				str.append(temp % 10);
			} else if (l2 >= 0) {
				int temp = num2.charAt(l2) - '0' + carry;
				carry = 0;
				if (temp / 10 > 0) {
					carry = 1;
				}
				l2--;
				str.append(temp % 10);
			}

			else if (carry != 0) {
				str.append(carry);
				carry = 0;
			}
		}

		return str.reverse().toString();
	}

	// Short Program
	public String addStrings2(String num1, String num2) {
		StringBuilder sb = new StringBuilder();

		int n1 = num1.length() - 1, n2 = num2.length() - 1;

		int carry = 0;

		while (n1 >= 0 || n2 >= 0) {
			int a = n1 < 0 ? 0 : num1.charAt(n1--) - '0';
			int b = n2 < 0 ? 0 : num2.charAt(n2--) - '0';

			sb.insert(0, (a + b + carry) % 10);
			carry = (a + b + carry) / 10;
		}

		if (carry == 1) {
			sb.insert(0, carry);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		addStrings("9", "99");
	}

}
