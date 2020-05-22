import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/find-the-town-judge/
//https://www.youtube.com/watch?v=Z2Hf1_H0aao

public class FindtheTownJudge_997 {

	//// Solution by Parampuneet Singh
	public static int findJudge(int N, int[][] trust) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		for (int[] t : trust) {
			List<Integer> l = map.getOrDefault(t[0], new ArrayList<Integer>());
			l.add(t[1]);
			map.put(t[0], l);
		}

		int res = -1;
		for (int i = 1; i <= N; i++) {
			if (!map.containsKey(i)) {
				res = i;
				for (int j = 1; j <= N; j++) {
					if (i != j && map.containsKey(j) && !map.get(j).contains(i)) {
						return -1;
					}
				}
			}
		}
		return res;
	}

	// Faster Solution
	public static int findJudge2(int N, int[][] trust) {
		int[] trust_count = new int[N];
		for (int[] t : trust) {
			trust_count[t[0] - 1]--;
			trust_count[t[1] - 1]++;
		}

		int result = -1;
		for (int i = 0; i < N; i++) {
			if (trust_count[i] == N - 1) {
				return i + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int N = 3;
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		System.out.println(findJudge2(N, trust));
	}

}
