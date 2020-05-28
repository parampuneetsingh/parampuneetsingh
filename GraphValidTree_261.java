import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.lintcode.com/problem/graph-valid-tree/description

public class GraphValidTree_261 {

	public boolean validTree(int n, int[][] edges) {
		if (edges.length == 0) {
			return n == 1;
		}

		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		for (int[] edge : edges) {
			map.putIfAbsent(edge[0], new ArrayList<Integer>());
			map.putIfAbsent(edge[1], new ArrayList<Integer>());

			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];

		if (!dfs(map, visited, 0, -1)) {
			return false;
		}

		for (boolean b : visited) {
			if (!b) {
				return false;
			}
		}

		return true;
	}

	private boolean dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, int idx, int parent) {
		if (visited[idx]) {
			return false;
		}

		visited[idx] = true;

		for (int i : map.get(idx)) {
			if (i != parent && !dfs(map, visited, i, idx)) {
				return false;
			}
		}

		return true;
	}

	// Solution 2
	public boolean validTree2(int n, int[][] edges) {
		if (edges.length == 0) {
			return n == 1;
		}

		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		for (int[] edge : edges) {
			map.putIfAbsent(edge[0], new ArrayList<Integer>());
			map.putIfAbsent(edge[1], new ArrayList<Integer>());

			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(map.keySet().iterator().next());

		while (!q.isEmpty()) {
			int key = q.poll();

			if (visited[key])
				return false;

			visited[key] = true;

			for (int j : map.get(key)) {
				if (!visited[j]) {
					q.add(j);
				}
			}
		}

		for (boolean b : visited) {
			if (!b) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		GraphValidTree_261 validTree = new GraphValidTree_261();
		// int n = 5;
		// int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } }; //True
		// int n = 3;
		// int[][] edges = { { 0, 1 } }; //False
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		System.out.println(validTree.validTree2(n, edges));
	}

}
