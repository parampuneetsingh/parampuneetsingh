import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.lintcode.com/problem/nested-list-weight-sum/

public class NestedListWeightSum_339 {
	
	class NestedInteger {

		public boolean isInteger() {
			// TODO Auto-generated method stub
			return false;
		}

		public int getInteger() {
			// TODO Auto-generated method stub
			return 0;
		}

		public List<NestedInteger> getList() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public int depthSum(List<NestedInteger> nestedList) {
		Queue<NestedInteger> q = new LinkedList<NestedInteger>();
		Queue<Integer> depth = new LinkedList<Integer>();
		int sum = 0;

		for (NestedInteger n : nestedList) {
			q.add(n);
			depth.add(1);
		}

		while (!q.isEmpty()) {
			NestedInteger nestedVal = q.poll();
			int d = depth.poll();

			if (nestedVal.isInteger()) {
				sum += d * nestedVal.getInteger();
			} else {
				for (NestedInteger val : nestedVal.getList()) {
					q.add(val);
					depth.add(d + 1);
				}
			}
		}
		return sum;
	}

}
