import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.lintcode.com/problem/add-bold-tag-in-string/
//http://buttercola.blogspot.com/2019/02/leetcode-616-add-bold-tag-in-string.html

public class AddBoldTaginString_616 {

	public void findIntervals(String s, String dictWord, List<int[]> intervals) {
		for (int i = 0; i < s.length() - dictWord.length() + 1; i++) {
			int j = 0;
			while (j < dictWord.length()) {
				if (s.charAt(i + j) == dictWord.charAt(j)) {
					j++;
				} else {
					break;
				}
			}
			if (j == dictWord.length()) {
				int[] interval = new int[] { i, i + j };
				intervals.add(interval);
			}
		}
	}

	public String addBoldTag(String s, String[] dict) {
		List<int[]> intervals = new ArrayList<int[]>();
		StringBuilder sb = new StringBuilder();

		for (String str : dict) {
			findIntervals(s, str, intervals);
		}

		Collections.sort(intervals, (a, b) -> a[0] - b[0]);
		
		List<int[]> mergedList = new ArrayList<int[]>();

		int[] prev = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			int[] curr = intervals.get(i);

			if (prev[1] >= curr[0]) {
				prev[1] = Math.max(prev[1], curr[1]);
			} else {
				mergedList.add(prev);
				prev = curr;
			}
		}

		mergedList.add(prev);

		int start = 0;
		for (int i = 0; i < mergedList.size(); i++) {
			int[] curr = mergedList.get(i);
			sb.append(s.substring(start, curr[0]));
			sb.append("<b>");
			sb.append(s.substring(curr[0], curr[1]));
			sb.append("</b>");

			start = curr[1];
		}

		if (start < s.length()) {
			sb.append(s.substring(start));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		AddBoldTaginString_616 add = new AddBoldTaginString_616();
		// String s = "aaabbcc";
		// String[] dict = { "aaa", "aab", "bc" };
		String s = "abcxyz123";
		String[] dict = { "abc", "123" };

		System.out.println(add.addBoldTag(s, dict));
	}

}
