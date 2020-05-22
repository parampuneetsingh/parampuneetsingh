import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/open-the-lock/
//https://www.youtube.com/watch?v=IHT8Sx0832k

public class OpenTheLock_752 {

	public int openLock(String[] deadends, String target) {

		HashSet<String> dead_ends = new HashSet<String>(Arrays.asList(deadends));

		HashSet<String> visited = new HashSet<String>();
		visited.add("0000");

		Queue<String> queue = new LinkedList<String>();
		queue.add("0000");

		int level = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size > 0) {
				String lock_position = queue.poll();
				if (dead_ends.contains(lock_position)) {
					return -1;
				}

				if (lock_position.equals(target)) {
					return level;
				}

				StringBuilder sb = new StringBuilder(lock_position);

				for (int i = 0; i < 4; i++) {
					char curr_position = sb.charAt(i);
					String s1 = sb.substring(0, i) + (curr_position == '9' ? 0 : curr_position - '0' + 1)
							+ sb.substring(i + 1);
					String s2 = sb.substring(0, i) + (curr_position == '0' ? 9 : curr_position - '0' - 1)
							+ sb.substring(i + 1);

					if (!visited.contains(s1) && !dead_ends.contains(s1)) {
						queue.offer(s1);
						visited.add(s1);
					}

					if (!visited.contains(s2) && !dead_ends.contains(s2)) {
						queue.offer(s2);
						visited.add(s2);
					}
				}
				size--;
			}
			level++;
		}
		return -1;
	}

	public static void main(String[] args) {
		OpenTheLock_752 lock = new OpenTheLock_752();
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";

		System.out.println(lock.openLock(deadends, target));
	}

}
