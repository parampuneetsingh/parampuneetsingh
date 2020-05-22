import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-ii/

public class BasicCalculatorII_227 {

	public int calculate(String s) {
		Stack<Integer> stk = new Stack<Integer>();
		int val = 0;
		if (s == null || s.length() == 0) {
			return 0;
		}

		char operator = '+';

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				val = val * 10 + (c - '0');
			}
			if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
				switch (operator) {
				case '+':
					stk.push(val);
					break;

				case '-':
					stk.push(-val);
					break;

				case '/':
					stk.push(stk.pop() / val);
					break;

				case '*':
					stk.push(stk.pop() * val);
					break;
				}
				operator = c;
				val = 0;
			}
		}

		int res = 0;
		while (!stk.isEmpty()) {
			res += stk.pop();
		}

		return res;
	}

	public static void main(String[] args) {
		BasicCalculatorII_227 calc = new BasicCalculatorII_227();
		String s = "3-2*2";
		System.out.println(calc.calculate(s));
	}

}
