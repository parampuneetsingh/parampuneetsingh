import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/articles/most-stones-removed-with-same-row-or-column/
//Understand Disjoint Sets -> https://www.youtube.com/watch?v=ID00PMy0-vE

public class MostStonesRemovedWithSameRowOrColumn_947 {

	class DSU {
		int[] parent;

		public DSU(int N) {
			parent = new int[N];
			for (int i = 0; i < N; ++i)
				parent[i] = i;
		}

		public int find(int x) {
			if (parent[x] != x) {
				parent[x] = find(parent[x]);
			}
			return parent[x];
		}

		public void union(int x, int y) {
			parent[find(x)] = find(y);
		}
	}

	public int removeStones(int[][] stones) {
		int N = stones.length;
		DSU dsu = new DSU(20);

		for (int[] stone : stones)
			dsu.union(stone[0], stone[1] + 10);

		Set<Integer> seen = new HashSet<Integer>();
		for (int[] stone : stones)
			seen.add(dsu.find(stone[0]));

		return N - seen.size();
	}

	public static void main(String[] args) {
		MostStonesRemovedWithSameRowOrColumn_947 find = new MostStonesRemovedWithSameRowOrColumn_947();
		int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };

		find.removeStones(stones);

	}

}
