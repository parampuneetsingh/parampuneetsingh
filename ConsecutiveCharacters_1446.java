//https://leetcode.com/problems/consecutive-characters/

public class ConsecutiveCharacters_1446 {

	public static int maxPower(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int res = 1;
		int max = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				max++;
			} else {
				res = Math.max(res, max);
				max = 1;
			}
		}

		return Math.max(res, max);
	}

	public static void main(String[] args) {
		String s = "hooraaaaaaaaaaay";
		System.out.println(maxPower(s));
	}

}
