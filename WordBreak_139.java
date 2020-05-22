import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/word-break/
//https://www.youtube.com/watch?v=YxtQUbKbdUs

public class WordBreak_139 {

	//TimeComplexity O(N^2)
	public boolean wordBreak2(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];

		dp[0] = true;

		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j]) {
					continue;
				}

				if (wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		WordBreak_139 word = new WordBreak_139();
		//String s = "applepenapple";
		//String[] wordDict = { "apple", "pen" };
		String s = "leetcode";
		String[] wordDict = { "leet", "code" };
		System.out.println(word.wordBreak2(s, Arrays.asList(wordDict)));
	}

}
