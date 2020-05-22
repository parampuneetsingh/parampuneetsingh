public class RotatedDigits_788 {

	public static boolean isValid(int N) {
		/*
		 * Valid if N contains ATLEAST ONE 2, 5, 6, 9 AND NO 3, 4 or 7s
		 */
		boolean validFound = false;

		while (N > 0) {
			if (N % 10 == 2)
				validFound = true;
			if (N % 10 == 5)
				validFound = true;
			if (N % 10 == 6)
				validFound = true;
			if (N % 10 == 9)
				validFound = true;
			if (N % 10 == 3)
				return false;
			if (N % 10 == 4)
				return false;
			if (N % 10 == 7)
				return false;
			N = N / 10;
		}
		return validFound;
	}

	public static void main(String[] args) {
		int N = 857;
		int count = 0;
		for (int i = 2; i <= N; i++) {
			if (isValid(i))
				count++;
		}
		System.out.println(count);
	}

}
