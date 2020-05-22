//https://leetcode.com/problems/add-digits/

public class AddDigits_258 {

	public static int addDigits(int num) {

		while (num / 10 != 0) {
			int n = num;
			int sum = 0;
			while (n != 0) {
				sum += n % 10;
				n = n / 10;
			}
			num = sum;
		}

		return num;
	}

	//Faster Approach
	public static int addDigits2(int num) {
		if (num == 0)
			return 0;
		return num % 9 == 0 ? 9 : num % 9;
	}

	public static void main(String[] args) {
		System.out.println(addDigits2(38));
	}

}
