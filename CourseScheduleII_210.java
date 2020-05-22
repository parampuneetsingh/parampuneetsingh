import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii/

//Topological Sort Problem
public class CourseScheduleII_210 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		int counter = 0;
		int[] completed = new int[numCourses];
		int[] res = new int[numCourses];

		Queue<Integer> q = new LinkedList<Integer>();

		for (int[] pre : prerequisites) {
			List<Integer> list = map.getOrDefault(pre[1], new ArrayList<Integer>());
			list.add(pre[0]);
			completed[pre[0]]++;
			map.put(pre[1], list);
		}

		for (int i = 0; i < numCourses; i++) {
			if (completed[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int qVal = q.poll();

			if (completed[qVal] == 0) {
				res[counter++] = qVal;
			}

			if (map.containsKey(qVal)) {
				for (int n : map.get(qVal)) {
					completed[n]--;
					if (completed[n] == 0) {
						q.add(n);
					}
				}
			}
		}

		return counter == numCourses ? res : new int[0];
	}

	public static void main(String[] args) {
		CourseScheduleII_210 courses = new CourseScheduleII_210();

		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int numCourses = 4;

		/*
		 * int[][] prerequisites = {{0,1}, {1,0}}; 
		 * int numCourses = 2;
		 */
		courses.findOrder(numCourses, prerequisites);
	}

}
