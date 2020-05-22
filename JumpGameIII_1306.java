//https://leetcode.com/problems/jump-game-iii/

public class JumpGameIII_1306 {

	public boolean checkVisited(int[] arr, int start, boolean[] visited) {
		if (start < 0 || start >= arr.length || visited[start]) {
			return false;
		}

		if (arr[start] == 0) {
			return true;
		}

		visited[start] = true;
		return checkVisited(arr, start + arr[start], visited) || checkVisited(arr, start - arr[start], visited);

	}

	public boolean canReach(int[] arr, int start) {
		int n = arr.length;
		boolean[] visited = new boolean[n];

		return checkVisited(arr, start, visited);
	}

	public static void main(String[] args) {
		JumpGameIII_1306 checkJump = new JumpGameIII_1306();
		int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
		int start = 0;
		// int[] arr = { 3, 0, 2, 1, 2 };
		// int start = 2;
		System.out.println(checkJump.canReach(arr, start));
	}

}
