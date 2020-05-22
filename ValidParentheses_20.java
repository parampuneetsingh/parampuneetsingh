import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses_20 {

	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		Stack<Character> stk = new Stack<Character>();

		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (map.containsKey(c)) {
				char t = stk.isEmpty() ? '#' : stk.pop();

				if (t != map.get(c)) {
					return false;
				}
			} else {
				stk.push(c);	
			}
		}
		return stk.isEmpty();
	}

	public static void main(String[] args) {
		String s = "{[]}";
		System.out.println(isValid(s));
		
	}

}
