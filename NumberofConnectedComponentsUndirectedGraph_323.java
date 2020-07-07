import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://github.com/openset/leetcode/tree/master/problems/number-of-connected-components-in-an-undirected-graph

public class NumberofConnectedComponentsUndirectedGraph_323 {

	// Using Graph
	public int countComponents(int n, int[][] edges) {
		Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		int count = 0;

		for (int[] edge : edges) {
			int a = edge[0], b = edge[1];
			graph.putIfAbsent(a, new ArrayList<Integer>());
			graph.putIfAbsent(b, new ArrayList<Integer>());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		while (graph.size() > 0) {
			Queue<Integer> queue = new LinkedList<>();
			while (!graph.containsKey(n))
				n--;
			queue.add(n);
			while (!queue.isEmpty()) {
				int v = queue.poll();
				if (!graph.containsKey(v))
					continue;
				queue.addAll(graph.get(v));
				graph.remove(v);
			}
			count++;
		}

		return count;
	}

	// Using Union-Find Disjoint Set
	public int countComponents2(int n, int[][] edges) {
		int count = n;

		int[] root = new int[n];
		// initialize each node is an island
		for (int i = 0; i < n; i++) {
			root[i] = i;
		}

		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			int xRoot = getRoot(root, x);
			int yRoot = getRoot(root, y);

			if (xRoot != yRoot) {
				count--;
				root[xRoot] = yRoot;
			}

		}

		return count;
	}

	public int getRoot(int[] arr, int i) {
		while (arr[i] != i) {
			arr[i] = arr[arr[i]];
			i = arr[i];
		}
		return i;
	}

	public static void main(String[] args) {
		NumberofConnectedComponentsUndirectedGraph_323 components = new NumberofConnectedComponentsUndirectedGraph_323();
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		// int n = 5;
		// int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
		System.out.println(components.countComponents2(n, edges));
	}

}
