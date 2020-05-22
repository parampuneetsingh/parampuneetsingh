import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
//https://www.youtube.com/watch?v=fvEw13A5O1o
//https://massivealgorithms.blogspot.com/2016/10/leetcode-438-find-all-anagrams-in-string.html

//Sliding Window approach
public class FindAllAnagramsinaString_438 {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();

		int sLen = s.length();

		int[] ary = new int[26];

		for (char c : p.toCharArray()) {
			ary[c - 'a']++;
		}

		int left = 0;
		int right = 0;
		int count = p.length();

		while (right < sLen) {

			if (ary[s.charAt(right++) - 'a']-- >= 1) {
				count--;
			}

			if (count == 0) {
				list.add(left);
			}

			if (right - left == p.length() && ary[s.charAt(left++) - 'a']++ >= 0) {
				count++;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		FindAllAnagramsinaString_438 anagram = new FindAllAnagramsinaString_438();
		String s = "cbaebabacd", p = "abc";
		System.out.println(anagram.findAnagrams(s, p));
	}

}
