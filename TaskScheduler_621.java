//https://leetcode.com/problems/task-scheduler/

import java.util.Arrays;

public class TaskScheduler_621 {

	public int leastInterval(char[] tasks, int n) {
		int[] ary = new int[26];

		for (char c : tasks) {
			ary[c - 'A']++;
		}

		int taskNums = 0;
		Arrays.sort(ary);

		while (ary[25] > 0) {
			int t = 0;

			while (t <= n) {
				if (ary[25] == 0) {
					break;
				}
				if (t < 26 && ary[25 - t] > 0) {
					ary[25 - t]--;
				}
				taskNums++;
				t++;
			}
			Arrays.sort(ary);
		}
		return taskNums;
	}

	public static void main(String[] args) {
		TaskScheduler_621 task = new TaskScheduler_621();
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 0;
		System.out.println(task.leastInterval(tasks, n));
	}

}
