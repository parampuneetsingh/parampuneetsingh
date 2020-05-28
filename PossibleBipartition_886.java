import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/possible-bipartition/
//https://www.youtube.com/watch?v=tfWcPtz91kE

//Similar problem to 785
public class PossibleBipartition_886 {

	public boolean possibleBipartition(int N, int[][] dislikes) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();

		for (int[] dislike : dislikes) {
			map.putIfAbsent(dislike[0], new HashSet<Integer>());
			map.putIfAbsent(dislike[1], new HashSet<Integer>());

			map.get(dislike[0]).add(dislike[1]);
			map.get(dislike[1]).add(dislike[0]);
		}

		int[] colors = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (colors[i] == 0 && !dfs(colors, 1, i, map)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int[] colors, int color, int node, HashMap<Integer, HashSet<Integer>> map) {
		if (colors[node] != 0) {
			return colors[node] == color;
		}

		colors[node] = color;
		if (map.get(node) == null) {
			return true;
		}
		for (int next : map.get(node)) {
			if (!dfs(colors, -color, next, map)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		PossibleBipartition_886 bipartition = new PossibleBipartition_886();
		int N = 4;
		int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } }; // True

		// int N = 5;
		// int[][] dislikes = {{1,2},{2,3},{3,4},{4,5},{1,5}}; // False
		System.out.println(bipartition.possibleBipartition(N, dislikes));
	}

}
