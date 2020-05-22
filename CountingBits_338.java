//https://leetcode.com/problems/counting-bits/

public class CountingBits_338 {

	public void findBits(int[] res, int i) {
		int t = i;
		int count = 0;

		while (t > 0) {
			if ((t & 1) == 1) {
				count++;
			}
			t = t >> 1;
		}
		res[i] = count;
	}

	// run time complexity O(n*sizeof(integer))
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;

		for (int i = 1; i <= num; i++) {
			findBits(res, i);
		}

		return res;
	}

	public int[] countBits2(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				res[i] = res[i / 2];
			} else {
				res[i] = res[i / 2] + 1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		CountingBits_338 count = new CountingBits_338();
		int num = 5;
		// CountBits2 is better and Faster solution
		System.out.println(count.countBits2(num));
	}

}
