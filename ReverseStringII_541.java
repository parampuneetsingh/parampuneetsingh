//https://leetcode.com/problems/reverse-string-ii/

public class ReverseStringII_541 {

	public String reverseSubString(String s, int k) {
		int i = 0, l = k - 1;

		char[] chrAry = s.toCharArray();

		if (s.length() <= k) {
			return new StringBuilder(s).reverse().toString();
		}

		while (i < l) {
			char t = chrAry[i];
			chrAry[i] = chrAry[l];
			chrAry[l] = t;
			i++;
			l--;
		}

		return String.valueOf(chrAry);
	}

	public String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i += 2 * k) {
			if (i + (2 * k) < s.length()) {
				sb.append(reverseSubString(s.substring(i, i + (2 * k)), k));
			} else {
				sb.append(reverseSubString(s.substring(i), k));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseStringII_541 reverse = new ReverseStringII_541();
		String s = "abcdefg";
		int k = 3;
		System.out.println(reverse.reverseStr(s, k));
	}

}
