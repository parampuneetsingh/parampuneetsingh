import java.util.HashSet;

//https://leetcode.com/problems/happy-number/

public class HappyNumber_202 {

	public static int square(int n) {
		int sum = 0;

		while (n > 0) {
			int temp = n % 10;
			sum += temp * temp;
			n = n / 10;
		}
		return sum;
	}

	// Solution 2
	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();

		while (n != 1) {
			int next = square(n);

			if (set.contains(n)) {
				return false;
			}

			set.add(n);
			n = next;
		}

		return true;
	}

	public static void main(String[] args) {
		int n = 19;

		System.out.println(isHappy(n));

	}

}