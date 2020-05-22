import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/similar-string-groups/

public class SimilarStringGroups_839 {

	//Incorrect Solution
	public static int numSimilarGroups(String[] A) {
		List<HashSet<String>> list = new ArrayList<HashSet<String>>();

		HashSet<String> set;

		for (int i = 0; i < A.length; i++) {
			int count = 0;
			set = new HashSet<String>();
			String first = A[i];
			set.add(first);
			for (int j = 0; j < A.length; j++) {
				String second = A[j];
				int l = 0;
				while (l < first.length()) {
					if (first.charAt(l) != second.charAt(l)) {
						count++;
					}
					l++;
				}
				if (count == 2) {
					set.add(second);
				}
			}

			int index = -1;
			for (int k = 0; k < list.size(); k++) {
				HashSet<String> s = list.get(k);
				for (String val : set) {
					if (s.contains(val)) {
						index = k;
					}
				}
			}
			if (index != -1) {
				list.get(index).addAll(set);
			} else {
				list.add(set);
			}
		}

		return list.size();
	}

	public static void main(String[] args) {
		String[] A = { "tars", "rats", "arts", "star" };
		//String[] A = { "blw", "bwl", "wlb" };
		System.out.println(numSimilarGroups(A));
	}

}
