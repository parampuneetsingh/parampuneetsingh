import java.util.Stack;

public class LongestValidParentheses_32 {

	public int longestValidParentheses(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}

	/*public int longestValidParentheses(String s) {
        int count = 0;
        if (s.length() == 0 || s.length() == 1) {
			return 0;
		}
        
		Stack<Character> stk1 = new Stack<Character>();
		
		int strLength = s.length();

		for (int i = 0; i < strLength; i++) {
			if (s.charAt(i) == '(') {
				stk1.push(s.charAt(i));
			}
            else if (s.charAt(i) == ')') {
				char tempChar = 0;
				if (!stk1.isEmpty()) {
					tempChar = stk1.pop();
				}
				if (tempChar == '(') {
					count += 2;
				}
			}
        }

		return count;
    }*/
	
	public static void main(String[] args) {
		LongestValidParentheses_32 LVP = new LongestValidParentheses_32();
		int count = LVP.longestValidParentheses("()(()"); //https://leetcode.com/problems/longest-valid-parentheses/solution/
		System.out.println(count);
	}

}
