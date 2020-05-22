//https://leetcode.com/problems/longest-repeating-character-replacement/
//https://www.youtube.com/watch?v=00FmUN1pkGE

public class LongestRepeatingCharacterReplacement_424 {

	public int characterReplacement(String s, int k) {
		int max = 0, strLength = s.length();
		int start = 0, maxLength = 0;
		int[] chr = new int[26];

		for (int end = 0; end < strLength; end++) {
			chr[s.charAt(end) - 'A']++;

			max = Math.max(max, chr[s.charAt(end) - 'A']);

			while (end - start - max + 1 > k) {
				chr[s.charAt(start) - 'A']--;
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement_424 maxLength = new LongestRepeatingCharacterReplacement_424();
		System.out.println(maxLength.characterReplacement("ABAB", 2));
	}

}
