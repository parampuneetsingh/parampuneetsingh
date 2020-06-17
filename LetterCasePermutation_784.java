import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-case-permutation/

public class LetterCasePermutation_784 {

	public void helper(String S, StringBuilder sb, List<String> list, int idx) {
		if (idx >= S.length()) {
			list.add(sb.toString());
			return;
		}
		char c = S.charAt(idx);
		// We need to remove the last character in the StringBuilder before every new
		// call, since each call shares the same object.
		if (Character.isDigit(c)) {
			helper(S, sb.append(c), list, idx + 1);
			sb.setLength(sb.length() - 1);
		} else {
			char lower = Character.toLowerCase(c);
			char upper = Character.toUpperCase(c);
			helper(S, sb.append(lower), list, idx + 1);
			sb.setLength(sb.length() - 1);
			helper(S, sb.append(upper), list, idx + 1);
			sb.setLength(sb.length() - 1);
		}
	}

	public List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		helper(S, sb, res, 0);

		return res;
	}

	public static void main(String[] args) {
		LetterCasePermutation_784 permutation = new LetterCasePermutation_784();

		String S = "a1b2";
		System.out.println(permutation.letterCasePermutation(S));
	}

}
