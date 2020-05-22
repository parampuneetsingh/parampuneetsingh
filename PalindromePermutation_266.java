public class PalindromePermutation_266 {

	public static boolean findPermutation(String str) {
		char[] chr = str.toCharArray();
		int[] ary = new int[26];
		int counter = 0;
		for (char c : chr) {
			ary[c - 'a']++;
		}

		for (int k : ary) {
			if (k % 2 != 0) {
				counter++;
			}
		}
		return (counter > 1) ? false : true;
	}

	public static void main(String[] args) {
		boolean resp = findPermutation("carerac");
		System.out.println(resp);
	}
}