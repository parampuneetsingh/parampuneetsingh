//https://www.youtube.com/watch?v=Pj9378ZsCh4
//https://www.lintcode.com/problem/walls-and-gates/description

public class WallsAndGates_663 {

	public static void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					minDistance(rooms, i, j, 0);
				}
			}
		}
	}

	public static void minDistance(int[][] rooms, int i, int j, int sum) {
		if (i < 0 || i > rooms.length - 1 || j < 0 || j > rooms[0].length - 1 || rooms[i][j] < sum) {
			return;
		}

		rooms[i][j] = sum;

		minDistance(rooms, i - 1, j, sum + 1);
		minDistance(rooms, i + 1, j, sum + 1);
		minDistance(rooms, i, j - 1, sum + 1);
		minDistance(rooms, i, j + 1, sum + 1);
	}

	public static void main(String[] args) {
		int[][] rooms = { 
				{ 2147483647, -1, 0, 2147483647 }, 
				{ 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, 
				{ 0, -1, 2147483647, 2147483647 } };

		wallsAndGates(rooms);
	}
}
