import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.youtube.com/watch?v=Ej9R8SxP9c0

public class CampusBikes_1057 {

	public static int[] assignBikes(int[][] workers, int[][] bikes) {
		List<int[]>[] buckets = new ArrayList[2001];
		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int dis = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
				if (buckets[dis] == null) {
					buckets[dis] = new ArrayList<int[]>();
				}
				buckets[dis].add(new int[] { i, j });
			}
		}
		
		int[] res = new int[workers.length];
		Arrays.fill(res, -1);
		Set<Integer> assignedBike = new HashSet<Integer>();
		for (int i = 0; i < buckets.length && assignedBike.size() < workers.length; i++) {
			if (buckets[i] != null) {
				for (int[] pair : buckets[i]) {
					if (res[pair[0]] < 0 && !assignedBike.contains(pair[1])) {
						res[pair[0]] = pair[1];
						assignedBike.add(pair[1]);
					}
				}
			}
		}
		return res;
	}
/*
	0
	1
	2	{1,0}	Worker 0 can take the Bike 1
	3	(0,0) {1,1} [ (0,0) -> Worker 0 can take the Bike 0, but Worker 0 has already taken a bike. (1,1) -> Worked 1 can take Bike 1. But Bike 1 is already occupied]
	4
	5
	6	(0,1)	Worked 1 will take Bike 0
	*/
	public static void main(String[] args) {
		/*
		 * int[][] workers = { { 0, 0 }, { 1, 1 }, { 2, 0 } }, bikes = { { 1, 0 }, { 2,
		 * 2 }, { 2, 1 } };
		 */
		int[][] workers = { { 0, 0 }, { 2, 1 } }, 
				bikes = { { 1, 2 }, { 3, 3 } };
		System.out.println(assignBikes(workers, bikes));
	}

}
