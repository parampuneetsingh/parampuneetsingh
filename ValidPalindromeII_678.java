//https://leetcode.com/problems/valid-palindrome-ii/solution/
public class ValidPalindromeII_678 {

	public static boolean checkPalindrome(String s, int start, int end, boolean flag) {
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else if (flag) {
				flag = false;
				return checkPalindrome(s, start + 1, end, flag) || checkPalindrome(s, start, end - 1, flag);
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean validPalindrome(String s) {
		int start = 0, end = s.length() - 1;
		boolean flag = true;
		return checkPalindrome(s, start, end, flag);
	}

	public static void main(String[] args) {
		System.out.println(validPalindrome("abc"));
	}

}
