import java.util.Stack;

//https://leetcode.com/problems/decode-string/
//https://www.youtube.com/watch?v=gYxE9MR2f5Y

public class DecodeString_394 {

	public String decodeString(String s) {
		Stack<String> strStack = new Stack<String>();
		Stack<Integer> numStack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = c - '0';
				while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
					num = num * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				numStack.push(num);

			} else if (c == '[') {
				strStack.push(sb.toString());
				sb = new StringBuilder();
			} else if (c == ']') {
				StringBuilder temp = new StringBuilder(strStack.pop());
				int repeatedTimes = numStack.pop();

				for (int j = 0; j < repeatedTimes; j++) {
					temp.append(sb);
				}
				sb = temp;
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		DecodeString_394 decode = new DecodeString_394();
		//String s = "2[abc]3[cd]ef";
		String s = "3[a2[c]]";
		System.out.println(decode.decodeString(s));

	}

}
