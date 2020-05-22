import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		char[] chrAry = s.toCharArray();
		Stack<Character> chrStk = new Stack<Character>();

		for (int i = 0; i < chrAry.length; i++) {
			if (chrAry[i] == '(' || chrAry[i] == '{' || chrAry[i] == '[') {
				chrStk.push(chrAry[i]);
			} else if (chrAry[i] == ')') {
				if (chrStk.isEmpty()) {
					return false;
				} else {
					char temp = chrStk.pop();
					if (temp != '(') {
						return false;
					}
				}
			} else if (chrAry[i] == '}') {
				if (chrStk.isEmpty()) {
					return false;
				} else {
					char temp = chrStk.pop();
					if (temp != '{') {
						return false;
					}
				}
			} else if (chrAry[i] == ']') {
				if (chrStk.isEmpty()) {
					return false;
				} else {
					char temp = chrStk.pop();
					if (temp != '[') {
						return false;
					}
				}
			}
		}
		if (chrStk.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String str = "()";
		ValidParentheses vpr = new ValidParentheses();
		vpr.isValid(str);
	}

}
