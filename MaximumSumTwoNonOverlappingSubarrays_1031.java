
public class MaximumSumTwoNonOverlappingSubarrays_1031 {

	public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
		for (int i = 1; i < A.length; ++i)
			A[i] += A[i - 1];
		int res = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];
		for (int i = L + M; i < A.length; ++i) {
			///case 1: L subarray is always before M subarray
			Lmax = Math.max(Lmax, A[i - M] - A[i - L - M]);
			////case 2: M subarray is always before L subarray
			Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
			////compare two cases and update res
			res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = {0,6,5,2,2,5,1,9,4};
		int L = 1, M = 2;
		System.out.println(maxSumTwoNoOverlap(A, L, M));
	}

}
