public class MonotonicArray_896 {

	public static void main(String[] args) {
		int[] A = { 1, 2, 2, 3 };
		boolean increasing = true;
		boolean decreasing = true;

		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				increasing = false;
			}
			if (A[i] > A[i - 1]) {
				decreasing = false;
			}
		}
		System.out.println(increasing || decreasing);
	}
}