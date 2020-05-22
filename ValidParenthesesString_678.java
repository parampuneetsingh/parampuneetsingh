//https://leetcode.com/problems/valid-parenthesis-string/
//https://www.youtube.com/watch?v=2H9gMIIGyvY

public class ValidParenthesesString_678 {

	public boolean checkValidString(String s) {
		if (s.length() < 1) {
			return true;
		}

		int balance = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				balance--;
			} else {
				balance++;
			}
			if (balance < 0) {
				return false;
			}
		}

		if (balance == 0) {
			return true;
		}

		balance = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				balance--;
			} else {
				balance++;
			}
			if (balance < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean checkValidString2(String s) {
		int lo = 0, hi = 0;
		for (char c : s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0)
				break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}

	public static void main(String[] args) {
		ValidParenthesesString_678 LVP = new ValidParenthesesString_678();
		// boolean resp = LVP.isValidParenthese(")(");
		boolean resp2 = LVP.checkValidString("(*()");
		System.out.println(resp2);
	}

}
