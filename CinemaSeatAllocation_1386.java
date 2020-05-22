import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/cinema-seat-allocation/

public class CinemaSeatAllocation_1386 {

	//Not Working
	public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int res = 0;

		HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();

		for (int i = 0; i < reservedSeats.length; i++) {
			if (!map.containsKey(reservedSeats[i][0])) {
				map.put(reservedSeats[i][0], new PriorityQueue<>());
			}
			map.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
		}

		for (int i : map.keySet()) {
			if (!map.get(i).contains(10)) {
				map.get(i).add(11);
			}
			int prev = 1;
			while (!map.get(i).isEmpty()) {
				int curr = map.get(i).poll();
				if (curr - prev - 1>= 4) {
					res += (curr - prev - 1) / 4;
				}
				prev = curr;
			}
		}

		for (int j = 1; j <= n; j++) {
			if (!map.containsKey(j)) {
				res += 8;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// int n = 2;
		// int[][] reservedSeats = { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		// int n = 4;
		// int[][] reservedSeats = { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
		//int n = 2;
		//int[][] reservedSeats = { { 1, 5 }, { 2, 8 }, { 2, 10 }, { 2, 2 }, { 1, 6 }, { 1, 10 }, { 1, 1 }, { 2, 5 }, { 1, 2 } };
		int n = 4;
		int[][] reservedSeats = {{2,10},{3,1},{1,2},{2,2},{3,5},{4,1},{4,9},{2,7}};
		System.out.println(maxNumberOfFamilies(n, reservedSeats));
	}

}
