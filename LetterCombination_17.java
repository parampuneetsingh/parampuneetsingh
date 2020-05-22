import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination_17 {

	public void findCombination(String digits, HashMap<String, String> map, List<String> list, String combination) {
		if (digits.length() == 0) {
			list.add(combination);
			return;
		}

		String letter = digits.substring(0, 1);
		String word = map.get(letter);

		for (int i = 0; i < word.length(); i++) {
			String wordLetter = word.substring(i, i + 1);
			findCombination(digits.substring(1), map, list, combination + wordLetter);
		}
	}

	public List<String> letterCombinations(String digits) {
		HashMap<String, String> map = new HashMap<String, String>();
		List<String> list = new ArrayList<String>();

		if (digits.length() == 0) {
			return list;
		}

		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");

		findCombination(digits, map, list, "");

		return list;
	}

	public static void main(String[] args) {
		LetterCombination_17 letter = new LetterCombination_17();
		System.out.println(letter.letterCombinations("34").toString());// LeetCodeSolution

	}

}
