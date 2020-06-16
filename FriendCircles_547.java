//https://leetcode.com/problems/friend-circles/
//https://www.youtube.com/watch?v=2Dl3_h4TNZY

public class FriendCircles_547 {

	public void dfs(int[][] M, int v) {
		if (M[v][v] == 0) {
			return;
		}

		for (int i = 0; i < M.length; i++) {
			if (M[v][i] == 1) {
				M[v][i] = 0;
				dfs(M, i);
			}
		}
	}

	public int findCircleNum(int[][] M) {
		int circle = 0;

		for (int i = 0; i < M.length; i++) {
			if (M[i][i] == 1) {
				dfs(M, i);
				circle++;
			}
		}

		return circle;
	}

	public static void main(String[] args) {
		FriendCircles_547 circles = new FriendCircles_547();

		int[][] M = { { 1, 0, 0, 1 }, 
					  { 0, 1, 1, 0 }, 
					  { 0, 1, 1, 1 }, 
					  { 1, 0, 1, 1 } };
		System.out.println(circles.findCircleNum(M));
	}

}
