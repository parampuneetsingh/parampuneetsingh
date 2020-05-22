import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/
//https://www.youtube.com/watch?v=vbM41Zql228

public class RemoveKDigits_402 {

	public static String removeKdigits(String num, int k) {
		int n = num.length();
		if (n == k) {
			return "0";
		}

		Stack<Character> stk = new Stack<Character>();
		StringBuilder sb = new StringBuilder();

		int counter = 0;
		
		while(counter < n) {
            if (!stk.isEmpty() && k > 0 && stk.peek() > num.charAt(counter)) {
                stk.pop();
                k--;
            }
            
            stk.push(num.charAt(counter++));
        }
		
		
		while (counter < n) {
			char c = num.charAt(counter);

			while (k > 0 && !stk.isEmpty() && stk.peek() > c) {
				stk.pop();
				k--;
			}

			stk.push(c);
			counter++;
		}

		while (k > 0) {
			stk.pop();
			k--;
		}

		while (!stk.isEmpty()) {
			sb.append(stk.pop());
		}

		sb.reverse();
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		//String num = "1432219";
		//int k = 3;
		String num = "1234567890";
		int k = 9;
		System.out.println(removeKdigits(num, k));
	}

}
