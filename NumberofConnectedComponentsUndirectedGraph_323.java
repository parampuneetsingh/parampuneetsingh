import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://github.com/openset/leetcode/tree/master/problems/number-of-connected-components-in-an-undirected-graph

public class NumberofConnectedComponentsUndirectedGraph_323 {

	public static int countComponents(int n, int[][] edges) {
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

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		int n = 5;
		System.out.println(countComponents(n, edges));
	}

}
