//https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord_58 {

	/*
	 * public int lengthOfLastWord(String s) { 
	 * if (s.trim().equals("")) { 
	 * 		return 0;
	 * }
	 * 
	 * String[] str = s.trim().split(" ");
	 * 
	 * return str[str.length-1].length(); 
	 * }
	 */
	public int lengthOfLastWord(String s) {
		if (s.equals("")) {
			return 0;
		}

		int count = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (count == 0 && s.charAt(i) == ' ') {
				continue;
			}

			if (s.charAt(i) != ' ') {
				count++;
			} else {
				break;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		LengthOfLastWord_58 length = new LengthOfLastWord_58();
		int resp = length.lengthOfLastWord("a");
		System.out.println(resp);
	}
}
