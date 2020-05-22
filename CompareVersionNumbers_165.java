import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/compare-version-numbers/
public class CompareVersionNumbers_165 {

	public int compareVersion(String version1, String version2) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		for (String s : version1.split("\\.")) {
			list1.add(Integer.parseInt(s));
		}
		for (String s : version2.split("\\.")) {
			list2.add(Integer.parseInt(s));
		}

		if (list1.size() > list2.size()) {
			int n = list1.size() - list2.size();
			for (int i = 0; i < n; i++) {
				list2.add(0);
			}
		} else if (list2.size() > list1.size()) {
			int n = list2.size() - list1.size();
			for (int i = 0; i < n; i++) {
				list1.add(0);
			}
		}

		while (!(list1.isEmpty() && list2.isEmpty())) {
			if (list1.get(0) > list2.get(0)) {
				return 1;
			} else if (list1.get(0) < list2.get(0)) {
				return -1;
			}
			list1.remove(0);
			list2.remove(0);
		}

		return 0;
	}

	public static void main(String[] args) {
		CompareVersionNumbers_165 compare = new CompareVersionNumbers_165();
		String version1 = "1.0.1", version2 = "1";
		System.out.println(compare.compareVersion(version1, version2));
	}

}
