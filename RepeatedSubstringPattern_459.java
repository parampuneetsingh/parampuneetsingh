public class RepeatedSubstringPattern_459 {

	public boolean repeatedSubstringPattern(String s) {
		int len = s.length();

		for (int i = len / 2; i >= 1; i--) {
			if (len % i == 0) {
				int num_repeats = len / i;
				String subString = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < num_repeats; j++) {
					sb.append(subString);
				}
				if (sb.toString().equals(s))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern_459 test = new RepeatedSubstringPattern_459();
		test.repeatedSubstringPattern("babbabbabbabbab");
	}

}
