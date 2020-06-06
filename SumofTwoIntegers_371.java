//https://leetcode.com/problems/sum-of-two-integers/

public class SumofTwoIntegers_371 {

	public static int getSum(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b; // Add without carry
		int carry = (a & b) << 1; // Carry, but dont add
		return getSum(sum, carry);
	}

	public static void main(String[] args) {
		int a = 23, b = 5;
		System.out.println(getSum(a, b));
	}

}
