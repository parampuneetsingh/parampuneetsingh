//https://leetcode.com/problems/permutation-in-string/

public class PermutationInString_567 {

	public boolean checkInclusion(String s1, String s2) {
		int left = 0, right = 0;
		int count = s1.length();

		int[] ary = new int[26];

		for (char c : s1.toCharArray()) {
			ary[c - 'a']++;
		}

		while (right < s2.length()) {
			if (ary[s2.charAt(right++) - 'a']-- >= 1) {
				count--;
			}

			if (count == 0) {
				return true;
			}

			if (right - left == s1.length() && ary[s2.charAt(left++) - 'a']++ >= 0) {
				count++;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		PermutationInString_567 perm = new PermutationInString_567();
		String s1 = "ab", s2 = "eidbaooo";
		System.out.println(perm.checkInclusion(s1, s2));
	}

}
