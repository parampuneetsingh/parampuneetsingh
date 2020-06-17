import java.util.Stack;

//https://leetcode.com/problems/basic-calculator/

public class BasicCalculator_224 {

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int operand = 0;
		int result = 0; // For the on-going result
		int sign = 1; // 1 means positive, -1 means negative

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				operand = 10 * operand + (int) (ch - '0');
			} else if (ch == '+') {
				result += sign * operand;
				sign = 1;
				operand = 0;
			} else if (ch == '-') {
				result += sign * operand;
				sign = -1;
				operand = 0;
			} else if (ch == '(') {
				stack.push(result);
				stack.push(sign);
				sign = 1;
				result = 0;
			} else if (ch == ')') {
				result += sign * operand;
				result *= stack.pop();
				result += stack.pop();
				operand = 0;
			}
		}
		return result + (sign * operand);
	}

	public static void main(String[] args) {
		String s = " 2-1 + 2 ";
		System.out.println(calculate(s));
	}

}
