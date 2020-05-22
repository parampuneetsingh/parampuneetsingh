import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {

	public List<String> permutation(List<String> res, char[] a, char[] b, int tempA, int tempB) {

		if (tempA < a.length && tempB < b.length) {
			res.add(String.valueOf(a[tempA]) + String.valueOf(b[tempB]));
			if (tempB == b.length - 1) {
				tempA++;
				tempB = -1;
			}
			tempB++;
			permutation(res, a, b, tempA, tempB);
		}

		return res;
	}

	public List<String> letterCombinations(String digits) {
		Map<Character, String> digitMap = new HashMap<Character, String>();
		List<String> res = new ArrayList<String>();

		String a = null;
		String b = null;

		digitMap.put('0', "0");
		digitMap.put('1', "0");
		digitMap.put('2', "abc");
		digitMap.put('3', "def");
		digitMap.put('4', "ghi");
		digitMap.put('5', "jkl");
		digitMap.put('6', "mno");
		digitMap.put('7', "pqrs");
		digitMap.put('8', "tuv");
		digitMap.put('9', "wxyz");

		if (digits.length() == 0) {
			return new ArrayList<String>();
		}

		for (int i = 0; i < digits.length(); i++) {
			for (int j = i + 1; j < digits.length(); j++) {
				a = digitMap.get(digits.charAt(i));
				b = digitMap.get(digits.charAt(j));
				permutation(res, a.toCharArray(), b.toCharArray(), 0, 0);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		LetterCombinationPhoneNumber comb = new LetterCombinationPhoneNumber();
		List<String> resp = new ArrayList<String>();
		resp = comb.letterCombinations("234");
		for (String s : resp) {
			System.out.println(s);
		}

	}

}
