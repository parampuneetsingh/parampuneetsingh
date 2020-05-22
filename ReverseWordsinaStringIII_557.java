//https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class ReverseWordsinaStringIII_557 {

	public static String reverseWords(String s) {
		int t = 0;
		int k = 0;

		char[] strArray = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			if (strArray[i] == ' ') {
				t = i + 1;
			} else {
				k = t;
				while (k < i) {
					char c = strArray[k];
					strArray[k] = strArray[i];
					strArray[i] = c;
					k++;
				}
			}
		}

		return String.valueOf(strArray);
	}

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}

}
