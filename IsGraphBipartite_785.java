import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/is-graph-bipartite/
//https://www.youtube.com/watch?v=FofydiwP5YQ

public class IsGraphBipartite_785 {

	private boolean bfs(int node, int[][] graph, int[] color) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		color[node] = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int n : graph[curr]) {
				if (color[n] == color[curr])
					return false;
				if (color[n] == -1) {
					color[n] = 1 - color[curr];
					q.add(n);
				}
			}
		}
		return true;
	}

	// BFS
	public boolean isBipartiteBFS(int[][] graph) {
		int[] color = new int[graph.length];
		Arrays.fill(color, -1);
		for (int i = 0; i < graph.length; i++)
			if ((color[i] == -1) && !bfs(i, graph, color))
				return false;
		return true;
	}

	public static void main(String[] args) {
		IsGraphBipartite_785 bipartite = new IsGraphBipartite_785();
		int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		System.out.println(bipartite.isBipartiteBFS(graph));
	}

}
