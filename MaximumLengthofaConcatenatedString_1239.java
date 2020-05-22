import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

public class MaximumLengthofaConcatenatedString_1239 {

	int max = Integer.MIN_VALUE;

	public int maxLength(List<String> arr) {

		dfs(arr, "", 0);

		return max;
	}

	public void dfs(List<String> arr, String res, int index) {
		if (unique(res)) {
			max = Math.max(max, res.length());
		} else {
			return;
		}

		for (int i = index; i < arr.size(); i++) {
			dfs(arr, res + arr.get(i), i + 1);
		}
	}

	public boolean unique(String res) {
		char[] ch = new char[128];

		for (int i = 0; i < res.length(); i++) {
			++ch[res.charAt(i)];
			if (ch[res.charAt(i)] > 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MaximumLengthofaConcatenatedString_1239 maxLength = new MaximumLengthofaConcatenatedString_1239();
		String[] str = { "cha", "r", "act", "ers" };

		List<String> list = new ArrayList<String>();

		for (String s : str) {
			list.add(s);
		}

		System.out.println(maxLength.maxLength(list));
	}

}
