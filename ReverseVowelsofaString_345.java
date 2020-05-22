import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=1NXs_idViuQ
//https://leetcode.com/problems/reverse-vowels-of-a-string/

public class ReverseVowelsofaString_345 {

	public String reverseVowels(String s) {
		int n = s.length();
		char[] stringArray = s.toCharArray();

		Set<Character> sets = new HashSet<Character>();
		sets.add('a');
		sets.add('e');
		sets.add('i');
		sets.add('o');
		sets.add('u');
		sets.add('A');
		sets.add('E');
		sets.add('I');
		sets.add('O');
		sets.add('U');

		int low = 0, high = n - 1;

		while (low < high) {
			char l = stringArray[low];
			char h = stringArray[high];

			if (sets.contains(l) && sets.contains(h)) {
				char c = stringArray[low];
				stringArray[low] = stringArray[high];
				stringArray[high] = c;
				low++;
				high--;
			}
			if (!sets.contains(l)) {
				low++;
			}
			if (!sets.contains(h)) {
				high--;
			}
		}

		return String.valueOf(stringArray);
	}

	public static void main(String[] args) {
		ReverseVowelsofaString_345 reverse = new ReverseVowelsofaString_345();
		String s = "hello";
		System.out.println(reverse.reverseVowels(s));
	}

}
