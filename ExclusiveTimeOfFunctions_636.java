import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeOfFunctions_636 {

	public int[] exclusiveTime(int n, List<String> logs) {
		Deque<Integer> stack = new ArrayDeque<Integer>();

		int[] res = new int[n];

		String[] s = logs.get(0).split(":");
		stack.push(Integer.valueOf(s[0]));

		int prev = Integer.valueOf(s[2]);

		for (int i = 1; i < logs.size(); i++) {
			s = logs.get(i).split(":");

			int func = Integer.valueOf(s[0]);
			int time = Integer.valueOf(s[2]);

			if (s[1].equals("start")) {
				if (!stack.isEmpty()) {
					res[stack.peek()] += time - prev;
				}
				stack.push(func);
				prev = time;
			} else {
				res[stack.pop()] += time - prev + 1;
				prev = time + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ExclusiveTimeOfFunctions_636 checkFunctions = new ExclusiveTimeOfFunctions_636();
		int n = 2;
		String[] logs = { "0:start:0", "1:start:2", "1:end:5", "0:end:6" };
		System.out.println(checkFunctions.exclusiveTime(n, Arrays.asList(logs)));
	}

}
