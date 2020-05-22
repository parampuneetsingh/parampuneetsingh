import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle_939 {

	public int minAreaRect(int[][] ps) {
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int[] p : ps) {
			map.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
		}

		for (int[] point : ps) {
			map.computeIfAbsent(point[0], k -> new HashSet<>()).add(point[1]);
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < ps.length; i++) {
			for (int j = i + 1; j < ps.length; j++) {
				int[] a = ps[i], b = ps[j];
				if (a[0] == b[0] || a[1] == b[1])
					continue;
				if (map.get(a[0]).contains(b[1]) && map.get(b[0]).contains(a[1])) {
					res = Math.min(res, Math.abs((a[0] - b[0]) * (a[1] - b[1])));
				}
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public static void main(String[] args) {
		// int[][] ps = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
		int[][] ps = { { 3, 2 }, { 3, 1 }, { 4, 4 }, { 1, 1 }, { 4, 3 }, { 0, 3 }, { 0, 2 }, { 4, 0 } };
		MinimumAreaRectangle_939 minArea = new MinimumAreaRectangle_939();
		System.out.println(minArea.minAreaRect(ps));
	}

}
