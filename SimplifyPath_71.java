import java.util.Stack;

//https://leetcode.com/problems/simplify-path/

public class SimplifyPath_71 {

	public static String simplifyPath(String path) {
		Stack<String> stk = new Stack<String>();

		String[] splitPath = path.split("/");

		for (String s : splitPath) {
			if (s.isEmpty() || s.equals(".")) {
				continue;
			} else if (!s.equals("..")) {
				stk.push(s);
			} else if (!stk.isEmpty()) {
				stk.pop();
			}
		}

		if (stk.isEmpty()) {
			return "/";
		}

		StringBuilder sb = new StringBuilder();

		while (!stk.isEmpty()) {
			sb.insert(0, "/" + stk.pop());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String path = "/a/../../b/../c//.//";
		System.out.println(simplifyPath(path));
	}

}
