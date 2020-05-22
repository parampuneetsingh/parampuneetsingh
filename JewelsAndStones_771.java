import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/jewels-and-stones/

public class JewelsAndStones_771 {

	public int numJewelsInStones(String J, String S) {
		Set<Character> set = new HashSet<Character>();
		int jewels = 0;

		if (J == null || J.length() == 0) {
			return jewels;
		}

		for (char c : J.toCharArray()) {
			set.add(c);
		}

		for (int i = 0; i < S.length(); i++) {
			if (set.contains(S.charAt(i))) {
				jewels++;
			}
		}

		return jewels;
	}

	public static void main(String[] args) {
		JewelsAndStones_771 findJewels = new JewelsAndStones_771();
		String J = "aA", S = "aAAbbbb";
		System.out.println(findJewels.numJewelsInStones(J, S));
	}

}
