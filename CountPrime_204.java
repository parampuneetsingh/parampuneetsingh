//https://leetcode.com/problems/count-primes/
//https://www.youtube.com/watch?v=4kRJnWbt_CI

public class CountPrime_204 {

	public int countPrimes(int n) {
		boolean[] nums = new boolean[n];
		int count = 0;

		for (int i = 2; i < n / 2; i++) {
			for (int j = i; j * i < n; j++) {
				nums[j * i] = true;
			}
		}

		for (int k = 2; k < n; k++) {
			if (!nums[k]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountPrime_204 count = new CountPrime_204();
		count.countPrimes(10);
	}
}
