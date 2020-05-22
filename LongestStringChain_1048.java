import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain_1048 {

	private boolean oneCharDiff(String small, String big) {
		for (int i = 0; i < small.length(); i++) {
			if (small.charAt(i) != big.charAt(i)) {
				return small.substring(i).equals(big.substring(i + 1));
			}
		}

		return true;
	}

	public int longestStrChain(String[] words) {
		int max = 1;
		Map<String, Integer> map = new HashMap<>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		for (int i = 0; i < words.length; i++) {
			map.put(words[i], 1);
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				String small = words[i];
				String big = words[j];
				if (big.length() - small.length() == 0)
					continue;
				if (big.length() - small.length() > 1)
					break;
				if (!oneCharDiff(small, big))
					continue;

				map.put(words[j], Math.max(map.get(big), map.get(small) + 1));
				max = Math.max(max, map.get(big));
			}
		}

		return max;
	}

	public int longestStrChain2(String[] words) {
		Map<String, Integer> dp = new HashMap<>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		int res = 0;
		for (String word : words) {
			int best = 0;
			for (int i = 0; i < word.length(); ++i) {
				String prev = word.substring(0, i) + word.substring(i + 1);
				best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
			}
			dp.put(word, best);
			res = Math.max(res, best);
		}
		return res;
	}

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		LongestStringChain_1048 chain = new LongestStringChain_1048();
		System.out.println(chain.longestStrChain2(words));
	}

}
