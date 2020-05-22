//https://leetcode.com/problems/ransom-note/

public class RansomNote_383 {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] ary = new int[26];

		for (char c : magazine.toCharArray()) {
			ary[c - 'a']++;
		}

		for (char c : ransomNote.toCharArray()) {
			if (ary[c - 'a'] > 0) {
				ary[c - 'a']--;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		RansomNote_383 note = new RansomNote_383();
		System.out.println(note.canConstruct("a", "b"));
		System.out.println(note.canConstruct("aa", "ab"));
		System.out.println(note.canConstruct("aa", "aab"));
	}

}
