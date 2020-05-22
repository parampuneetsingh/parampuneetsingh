import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.lintcode.com/problem/nested-list-weight-sum-ii/
public class NestedListWeightSumII_364 {

	class NestedInteger {

		public boolean isInteger() {
			// TODO Auto-generated method stub
			return false;
		}

		public Integer getInteger() {
			// TODO Auto-generated method stub
			return null;
		}

		public List<NestedInteger> getList() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public int depthSumInverse(List<NestedInteger> nestedList) {
		Queue<NestedInteger> q = new LinkedList<NestedInteger>();
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Queue<Integer> depth = new LinkedList<Integer>();

		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (NestedInteger n : nestedList) {
			q.add(n);
			depth.add(1);
		}

		while (!q.isEmpty()) {
			NestedInteger val = q.poll();
			int d = depth.poll();

			max = Math.max(max, d);

			if (val.isInteger()) {
				List<Integer> list = map.getOrDefault(d, new ArrayList<Integer>());
				list.add(val.getInteger());
				map.put(d, list);
			} else {
				for (NestedInteger n : val.getList()) {
					q.add(n);
					depth.add(d + 1);
				}
			}
		}

		max++;
		for (int key : map.keySet()) {
			for (int i : map.get(key)) {
				sum += ((max - key) * i);
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
