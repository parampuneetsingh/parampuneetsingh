//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//https://www.youtube.com/watch?v=thL70BR3yMA

public class MinimumRemoveMakeValidParentheses_1249 {

	public static String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder();
		int bracket = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				bracket++;
			} else if (c == ')') {
				if (bracket == 0)
					continue;
				bracket--;
			}

			sb.append(c);
		}

		StringBuilder result = new StringBuilder();
		for (int j = sb.length() - 1; j >= 0; j--) {
			char c = sb.charAt(j);
			if (c == '(' && bracket-- > 0)
				continue;
			result.append(c);
		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		System.out.println(minRemoveToMakeValid(s));
	}

}
