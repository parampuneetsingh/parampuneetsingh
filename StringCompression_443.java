//https://leetcode.com/problems/string-compression/

public class StringCompression_443 {

	public static int compress(char[] chars) {
		int idx = 0;
		int ans = 0;

		while (idx < chars.length) {
			char current = chars[idx];
			int count = 0;

			while (idx < chars.length && current == chars[idx]) {
				count++;
				idx++;
			}

			chars[ans++] = current;

			String temp = String.valueOf(count);

			if (count != 1) {
				for (int j = 0; j < temp.length(); j++) {
					chars[ans++] = temp.charAt(j);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		//char[] chars = { 'a', 'a', 'a', 'b', 'b', 'a', 'a' };
		// char[] chars = { 'a' };
		//Answer Will be {a , b , 1, 2 , b, b, b, b, b, b , b, b, b, b, b, b}
		char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(compress(chars));
	}

}
