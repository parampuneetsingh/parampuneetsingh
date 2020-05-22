import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

//https://leetcode.com/problems/accounts-merge/
//https://ttzztt.gitbooks.io/lc/content/accounts-merge.html

public class AccountsMerge_721 {

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		// initialize the union find & owner info
		Map<String, String> parent = new HashMap<String, String>(); // Map<String, Integer> rank = new HashMap<>();
		Map<String, TreeSet<String>> union = new HashMap<String, TreeSet<String>>();

		for (List<String> a : accounts) {
			for (int i = 1; i < a.size(); ++i) {
				parent.put(a.get(i), a.get(i));
				// rank.put(a.get(i), 0);
			}
		}

		for (List<String> a : accounts) {
			String p = find(a.get(1), parent);
			// merge the emails accounts
			for (int i = 2; i < a.size(); ++i) {
				String pi = find(a.get(i), parent);
				// union
				// by rank
				// if(rank.get(pi) > rank.get(p)){
				// String tmp = pi;
				// pi = p;
				// p = tmp;
				// }
				// int inc = rank.get(pi) == rank.get(p)?1:0;
				// rank.put(p, rank.get(p) + inc);
				parent.put(pi, p);
			}
		}

		// build the union where union<represented email, set of email accounts>
		for (List<String> a : accounts) {
			String p = find(a.get(1), parent);
			if (!union.containsKey(p)) {
				union.put(p, new TreeSet<>());
				union.get(p).add(a.get(0));// add name first
			}
			for (int i = 1; i < a.size(); ++i) {
				union.get(p).add(a.get(i));
			}
		}

		List<List<String>> res = new ArrayList<>();
		for (String p : union.keySet()) {
			List<String> email = new ArrayList<>(union.get(p));
			res.add(email);
		}

		return res;
	}

	private static String find(String q, Map<String, String> parent) {
		while (parent.get(q) != q) {
			// path compression
			// parent.put(q, parent.get(parent.get(q)));
			q = parent.get(q);
		}

		return q;
	}

	public static void main(String[] args) {
		String[][] accounts = { { "John", "johnsmith@mail.com", "john00@mail.com" }, { "John", "johnnybravo@mail.com" },
				{ "John", "johnsmith@mail.com", "john_newyork@mail.com" }, { "Mary", "mary@mail.com" } };

		List<List<String>> lst = new ArrayList<List<String>>();

		for (String[] s : accounts) {
			lst.add(Arrays.asList(s));
		}

		System.out.println(accountsMerge(lst).toString());
	}

}
