import java.util.ArrayList;
import java.util.List;

//http://buttercola.blogspot.com/2016/01/leetcode-generalized-abbreviation.html
//https://www.cnblogs.com/grandyang/p/5261569.html

public class GeneralizedAbbreviation_320 {

	// BFS
	public static List<String> generateAbbreviations2(String word) {
		List<String> res = new ArrayList<>();
		double limit = Math.pow(2, word.length());

		for (int i = 0; i < limit; i++) {
			String output = "";
			int count = 0, t = i;
			for (int j = 0; j < word.length(); j++) {
				if ((t & 1) == 1) {
					count++;
					if (j == word.length() - 1) {
						output += count;
					}
				} else {
					if (count != 0) {
						output += count;
						count = 0;
					}
					output += word.charAt(j);
				}
				t >>= 1;
			}
			res.add(output);
		}
		return res;
	}

	// DFS
	public static List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<>();

		result.add(word);
		generateHelper(0, word, result);

		return result;
	}

	private static void generateHelper(int start, String s, List<String> result) {
		if (start >= s.length()) {
			return;
		}

		for (int i = start; i < s.length(); i++) {
			for (int j = 1; i + j <= s.length(); j++) {
				String num = Integer.toString(j);
				String abbr = s.substring(0, i) + num + s.substring(i + j);
				result.add(abbr);
				generateHelper(i + 1 + num.length(), abbr, result); // skip 1b
			}
		}
	}

	public static void main(String[] args) {
		String word = "word";
		generateAbbreviations2(word);
	}

}
