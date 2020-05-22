import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/minimum-height-trees/

//Topological Problem
public class MinimumHeightTrees_310 {

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<Integer>();
		if (n <= 0 || edges == null || edges.length == 0) {
			return Arrays.asList(0);
		}

		int[] ary = new int[n];

		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int[] edge : edges) {
			List<Integer> list1 = map.getOrDefault(edge[0], new ArrayList<Integer>());
			List<Integer> list2 = map.getOrDefault(edge[1], new ArrayList<Integer>());
			list1.add(edge[1]);
			list2.add(edge[0]);
			map.put(edge[0], list1);
			map.put(edge[1], list2);
		}

		Queue<Integer> q = new LinkedList<Integer>();

		int c = 0;
		for (int key : map.keySet()) {
			ary[c++] = map.get(key).size();

			if (map.get(key).size() == 1) {
				q.add(key);
			}
		}

		while (n > 2) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int node = q.poll();
				for (int leaf : map.get(node)) {
					ary[leaf]--;
					if (ary[leaf] == 1) {
						q.add(leaf);
					}
				}
			}
			n = n - size;
		}

		result.addAll(q);

		return result;
	}

	public static void main(String[] args) {
		//int n = 4;
		//int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		int n = 6;
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		findMinHeightTrees(n, edges);
	}

}
