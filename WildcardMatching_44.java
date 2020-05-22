import java.util.Arrays;

//https://leetcode.com/problems/wildcard-matching
//https://www.youtube.com/watch?v=3ZDZ-N0EPV0

public class WildcardMatching_44 {

	// Change Multiple * to one *
	public String removeDuplicates(String p) {
		char[] charAry = p.toCharArray();

		char[] res = new char[p.length()];

		int counter = 0;
		for (int i = 0; i < charAry.length; i++) {
			if (charAry[i] == '*') {
				res[counter++] = '*';
				while (i < charAry.length && charAry[i] == '*') {
					i++;
				}
				i--;
			} else {
				res[counter++] = charAry[i];
			}
		}

		return String.copyValueOf(Arrays.copyOf(res, counter));
	}

	public boolean findMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;

		if (s.length() == 0 && p.charAt(0) == '*') {
			return isMatch(s, p.substring(1));
		}

		if (s.length() != 0 && s.charAt(0) == p.charAt(0)) {
			return findMatch(s.substring(1), p.substring(1));
		} else {
			if (s.length() != 0 && p.charAt(0) == '?') {
				return findMatch(s.substring(1), p.substring(1));
			} else {
				if (s.length() != 0 && p.charAt(0) == '*') {
					return findMatch(s.substring(1), p.substring(1)) || findMatch(s.substring(1), p)
							|| findMatch(s, p.substring(1));
				}
			}

		}

		return false;
	}

	// TimeOut Recursive Solution
	public boolean isMatch(String s, String p) {
		p = removeDuplicates(p);

		return findMatch(s, p);
	}

	//DP Solution
	public boolean isMatch2(String s, String p) {
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();

		// replace multiple * with one *
		// e.g a**b***c --> a*b*c
		int writeIndex = 0;
		boolean isFirst = true;
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == '*') {
				if (isFirst) {
					pattern[writeIndex++] = pattern[i];
					isFirst = false;
				}
			} else {
				pattern[writeIndex++] = pattern[i];
				isFirst = true;
			}
		}
		
		boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

		if (writeIndex > 0 && pattern[0] == '*') {
			T[0][1] = true;
		}

		T[0][0] = true;

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i - 1][j] || T[i][j - 1];
				}
			}
		}

		return T[str.length][writeIndex];
	}

	public static void main(String[] args) {
		WildcardMatching_44 match = new WildcardMatching_44();
		String s = "bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa";
		String p = "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****j";
		//Recursive Solution giving Timeout
		System.out.println(match.isMatch2(s, p));
		//DP Solution is working
		System.out.println(match.isMatch2(s, p));
	}

}
