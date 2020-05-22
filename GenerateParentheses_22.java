import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/

public class GenerateParentheses_22 {

	public void recurse(List<String> list, String curr, int open, int close, int n) {
		if (curr.length() == n * 2) {
			list.add(curr);
			return;
		}

		if (open < n) {
			recurse(list, curr + '(', open + 1, close, n);
		}

		if (close < open) {
			recurse(list, curr + ')', open, close + 1, n);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		recurse(list, "", 0, 0, n);
		return list;
	}

	public static void main(String[] args) {
		GenerateParentheses_22 gen = new GenerateParentheses_22();
		System.out.println(gen.generateParenthesis(3));
	}

}
