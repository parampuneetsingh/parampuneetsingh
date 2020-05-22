import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule/
//https://www.youtube.com/watch?v=rG2-_lgcZzo

//Topological Sort Problem
public class CourseSchedule_207 {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0;

		int[] dependency = new int[numCourses];

		for (int[] pre : prerequisites) {
			List<Integer> lst = map.getOrDefault(pre[1], new ArrayList<Integer>());
			lst.add(pre[0]);
			map.put(pre[1], lst);
			dependency[pre[0]]++;
		}

		for (int i = 0; i < dependency.length; i++) {
			if (dependency[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int temp = q.poll();

			if (dependency[temp] == 0) {
				count++;
			}

			if (!map.containsKey(temp)) {
				continue;
			}

			for (int i : map.get(temp)) {
				dependency[i]--;
				if (dependency[i] == 0) {
					q.add(i);
				}
			}
		}

		return count == numCourses;
	}

	public static void main(String[] args) {
		CourseSchedule_207 checkCourse = new CourseSchedule_207();
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 } }; // Courses -> 4 True
		// int[][] prerequisites = { { 1, 0 }, { 0, 1 } }; // Courses -> 2 False
		System.out.println(checkCourse.canFinish(numCourses, prerequisites));
	}

}
