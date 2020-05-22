import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://www.lintcode.com/problem/sequence-reconstruction/
//https://www.youtube.com/watch?v=_uFiCQRKbbQ

public class SequenceReconstruction_444 {

	public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Set<Integer>> path = new HashMap<>();

		for (int i = 0; i < seqs.length; i++) {
			int[] seq = seqs[i];
			if (seq.length == 1) {
				map.putIfAbsent(seq[0], 0);
				path.putIfAbsent(seq[0], new HashSet<>());
			} else {
				for (int j = 0; j < seq.length - 1; j++) {
					map.putIfAbsent(seq[0], 0);
					map.putIfAbsent(seq[0 + 1], 0);
					path.putIfAbsent(seq[0], new HashSet<>());
					path.putIfAbsent(seq[0 + 1], new HashSet<>());

					if (!path.get(seq[j]).contains(seq[j + 1])) {
						map.put(seq[j + 1], map.get(seq[j + 1]) + 1);
					}
					path.get(seq[j]).add(seq[j + 1]);
				}
			}
		}

		boolean start = false;
		int point = 0;
		for (Integer key : map.keySet()) {
			if (map.get(key) == 0) {
				start = true;
				point = key;
			}
		}

		if (!start) {
			return false;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(point);

		int index = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			if (size > 1) {
				return false;
			}
			int number = q.poll();
			if (index == org.length || org[index] != number) {
				return false;
			}
			index++;
			for (Integer child : path.get(number)) {
				map.put(child, map.get(child) - 1);
				if (map.get(child) == 0) {
					q.add(child);
				}
			}
		}

		return index == org.length && index == map.size();
	}

	public static void main(String[] args) {
		int[] org = { 1, 2, 3 };
		int[][] seqs = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		System.out.println(sequenceReconstruction(org, seqs));
	}

}
