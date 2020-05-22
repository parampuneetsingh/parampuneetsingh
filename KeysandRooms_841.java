//https://leetcode.com/problems/keys-and-rooms/
//https://www.youtube.com/watch?v=oYeGiShGn2k

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class KeysandRooms_841 {

	// Solution 1
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Queue<Integer> q = new LinkedList<Integer>();

		boolean[] visited = new boolean[rooms.size()];

		q.add(0);

		while (!q.isEmpty()) {
			int t = q.poll();

			visited[t] = true;

			for (int n : rooms.get(t)) {
				if (!visited[n]) {
					q.add(n);
				}
			}
		}

		for (boolean b : visited) {
			if (!b) {
				return false;
			}
		}

		return true;
	}

	// Solution 2
	public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
		// https://www.youtube.com/watch?v=oYeGiShGn2k
		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(0);

		Stack<Integer> stk = new Stack<Integer>();
		stk.add(0);

		while (!stk.isEmpty()) {
			int temp = stk.pop();
			for (int i : rooms.get(temp)) {
				if (!visited.contains(i)) {
					visited.add(i);
					stk.add(i);
				}
			}
		}
		return visited.size() == rooms.size();
	}

	public static void main(String[] args) {
		KeysandRooms_841 canVisit = new KeysandRooms_841();
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.add(0, new ArrayList<Integer>());
		rooms.add(1, new ArrayList<Integer>());
		rooms.add(2, new ArrayList<Integer>());
		rooms.add(3, new ArrayList<Integer>());
		rooms.get(0).add(1);
		rooms.get(1).add(2);
		rooms.get(2).add(3);

		/*
		 * rooms.get(0).add(1); rooms.get(0).add(3); rooms.get(1).add(3);
		 * rooms.get(1).add(0); rooms.get(1).add(1); rooms.get(2).add(2);
		 * rooms.get(3).add(0);
		 */
		canVisit.canVisitAllRooms(rooms);

	}

}
