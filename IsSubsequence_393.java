public class IsSubsequence_393 {

	public static boolean isSubsequence(String s, String t) {

		int sIndex = 0;
		int tIndex = 0;

		while (sIndex < s.length() && tIndex < t.length()) {
			if (s.charAt(sIndex) == t.charAt(tIndex)) {
				sIndex++;
			}
			tIndex++;
		}

		return sIndex == s.length();
	}

	public static void main(String[] args) {
		isSubsequence("abc", "ahbgdc");
	}

}
