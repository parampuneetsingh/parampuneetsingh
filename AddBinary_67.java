
public class AddBinary_67 {

	public String addBinaryStrings(String a, String b) {
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

	public String addBinaryStrings_2(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int S1 = a.length() - 1, S2 = b.length() - 1;
		int sum = 0;
		int carry = 0;
		while (S1 >= 0 || S2 >= 0) {
			int tempA = 0, tempB = 0;
			if (S1 >= 0) {
				tempA = a.charAt(S1) - '0';
				S1--;
			}
			if (S2 >= 0) {
				tempB = b.charAt(S2) - '0';
				S2--;
			}
			sum = tempA + tempB + carry;
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String a = "123";
		String b = "1251";
		AddBinary_67 sum = new AddBinary_67();
		String resp = sum.addBinaryStrings_2(a, b);
		System.out.println(resp);
	}

}
