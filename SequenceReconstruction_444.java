import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.lintcode.com/problem/sequence-reconstruction/
//https://www.youtube.com/watch?v=_uFiCQRKbbQ

public class SequenceReconstruction_444 {

	public static boolean sequenceReconstruction(int[] org, int[][] seqs) {

		int n = org.length;
		Map<Integer, Integer> indegree = new HashMap<>();
		int[] res = new int[n];

		Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int[] seq : seqs) {

			if (seq.length == 1) {
				if (!map.containsKey(seq[0])) {
					map.put(seq[0], new HashSet<>());
					indegree.put(seq[0], 0);
				}
			} else {
				for (int i = 0; i < seq.length - 1; i++) {

					int first = seq[i];
					int second = seq[i + 1];
					if (!map.containsKey(first)) {
						map.put(first, new HashSet<>());
						indegree.put(first, indegree.getOrDefault(first, 0));
					}
					if (!map.get(first).contains(second)) {
						map.get(first).add(second);
						indegree.put(second, indegree.getOrDefault(second, 0) + 1);
					}
				}
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();

		if (indegree.size() != n) {
			return false;
		}

		for (int d : indegree.keySet()) {
			if (indegree.get(d) == 0) {
				q.offer(d);
			}
		}

		int counter = 0;
		while (!q.isEmpty()) {
			if (q.size() > 1) {
				return false;
			}

			int t = q.poll();

			if (counter == n || org[counter] != t) {
				return false;
			}
			
			res[counter++] = t;

			if (!map.containsKey(t))
				continue;

			for (int key : map.get(t)) {
				indegree.put(key, indegree.get(key) - 1);
				if (indegree.get(key) == 0) {
					q.add(key);
				}
			}
		}

		return counter == n;
	}

	public static void main(String[] args) {
		int[] org = { 1, 2, 3 };
		int[][] seqs = { { 3, 2 }, { 2, 1 } };
		// int[][] seqs = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

		// int[] org = { 1 };
		// int[][] seqs = { { 1 } };
		// int[] org = { 4, 1, 5, 2, 6, 3 };
		// int[][] seqs = { { 5, 2, 6, 3 }, { 4, 1, 5, 2 } };
		System.out.println(sequenceReconstruction(org, seqs));
	}

}
