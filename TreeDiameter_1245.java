//https://github.com/openset/leetcode/tree/master/problems/tree-diameter
//https://github.com/GarhomLee/LeetCode/blob/master/1245.%20Tree%20Diameter.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeDiameter_1245 {

	public int treeDiameter(int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		for (int[] edge : edges) {
			int a = edge[0], b = edge[1];

			map.putIfAbsent(a, new ArrayList<Integer>());
			map.putIfAbsent(b, new ArrayList<Integer>());
			map.get(a).add(b);
			map.get(b).add(a);
		}

		boolean[] visited = new boolean[edges.length + 1];
		Queue<Integer> q = new LinkedList<Integer>();

		int t = 0;
		q.add(t);

		while (!q.isEmpty()) {
			t = q.poll();
			visited[t] = true;

			for (int i : map.get(t)) {
				if (visited[i]) {
					continue;
				}
				q.add(i);
			}
		}

		int dist = -1;
		q.clear();
		q.add(t);
		Arrays.fill(visited, false);

		while (!q.isEmpty()) {
			int size = q.size();
			visited[t] = true;

			while (size-- > 0) {
				t = q.poll();

				for (int i : map.get(t)) {
					if (visited[i]) {
						continue;
					}
					q.add(i);
				}
			}
			dist++;
		}

		return dist;
	}

	public static void main(String[] args) {
		TreeDiameter_1245 tree = new TreeDiameter_1245();
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 4 }, { 4, 5 } };
		System.out.println(tree.treeDiameter(edges));
	}

}
