import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/remove-invalid-parentheses/

public class RemoveInvalidParentheses_301 {

	public List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		HashSet<String> set = new HashSet<String>();
		queue.offer(s);
		set.add(s);
		while (!queue.isEmpty()) {
			if (ans.size() > 0)
				break;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (isValid(cur))
					ans.add(cur);
				else {
					for (int j = 0; j < cur.length(); j++) {
						if (cur.charAt(j) == '(' || cur.charAt(j) == ')') {
							String tmp = cur.substring(0, j) + cur.substring(j + 1);
							if (!set.contains(tmp)) {
								set.add(tmp);
								queue.offer(tmp);
							}

						}
					}
				}

			}
		}
		return ans;
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push('(');
			else if (s.charAt(i) == ')') {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses_301 remove = new RemoveInvalidParentheses_301();
		// String s = ")()()i)())b(())h))))";
		String s = "(a)())()";
		System.out.println(remove.removeInvalidParentheses(s));
	}

}
