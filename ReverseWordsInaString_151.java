//https://leetcode.com/problems/reverse-words-in-a-string/

public class ReverseWordsInaString_151 {

	public void reverse(char[] chrAry, int start, int end) {
		char temp = chrAry[start];
		chrAry[start] = chrAry[end];
		chrAry[end] = temp;
	}

	public String reverseWords(String s) {
		char[] chrAry = s.toCharArray();

		int start = 0;
		int end = s.length() - 1;
		int t = 0, k = 0;

		while (start < end) {
			reverse(chrAry, start, end);
			start++;
			end--;
		}

		for (int i = 0; i < s.length(); i++) {
			if (chrAry[i] == ' ') {
				i++;
				k = i;
			} else {
				t = k;
				while (t < i) {
					reverse(chrAry, t, i);
					t++;
				}
			}

		}

		int m = 0, n = 0;

		while (n < s.length()) {
			while (n < s.length() && chrAry[n] == ' ') {
				n++;
			}
			while (n < s.length() && chrAry[n] != ' ') {
				chrAry[m++] = chrAry[n++];
			}
			while (n < s.length() && chrAry[n] == ' ') {
				n++;
			}
			if (n < s.length())
				chrAry[m++] = ' ';
		}

		return new String(chrAry, 0, m);
	}

	public static void main(String[] args) {
		ReverseWordsInaString_151 rev = new ReverseWordsInaString_151();
		String input = "a good  example";
		rev.reverseWords(input);
	}
}