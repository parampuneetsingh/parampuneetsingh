
public class ReverseWordsinaStringII_186 {

	public static char[] reverseWords(char[] str) {

		int start = 0, end = str.length - 1;
		int t = 0, l = 0;

		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;

			start++;
			end--;
		}

		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				t = i + 1;
			} else {
				l = t;
				while (l < i) {
					char k = str[l];
					str[l] = str[i];
					str[i] = k;

					l++;
				}
			}
		}
		return str;
	}

	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s.toCharArray()));
	}

}
