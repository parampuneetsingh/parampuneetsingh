
public class PlusOneInArray_66 {

	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + carry == 10) {
				carry = 1;
				digits[i] = (digits[i] + carry) % 10;
			} else {
				digits[i] = (digits[i] + carry) % 10;
				carry = 0;
			}
		}
		if (carry == 1) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}
		return digits;
	}

	public int[] plusOne_2(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + carry;
			if (temp % 10 == 0) {
				carry = 1;
				digits[i] = 0;
			} else {
				carry = 0;
				digits[i] = temp;
			}
		}
		if (carry == 1) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}
		return digits;
	}

	public int[] plusOne_3(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
	
	public static void main(String[] args) {
		//int[] digits = { 9, 9, 9 };
		int[] digits = { 1, 2, 9 };
		PlusOneInArray_66 dgt = new PlusOneInArray_66();
		digits = dgt.plusOne_3(digits);

		for (int j : digits) {
			System.out.println(j);
		}
	}

}
