
//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
//https://www.youtube.com/watch?v=BFtsYTl3KP4

public class MinimumDominoRotations_1007 {

	public int minDominoRotations(int[] A, int[] B) {
		if (A[0] == B[0])
			return Count(A, B, A[0]);
		else
			return Math.max(Count(A, B, A[0]), Count(A, B, B[0]));
	}

	public int Count(int[] A, int[] B, int target) {
		int countTop = 0;
		int countBot = 0;
		int n = A.length;

		for (int i = 0; i != n; ++i) {
			if (A[i] != target && B[i] != target)
				return -1;
			else if (A[i] != target)
				++countTop;
			else if (B[i] != target)
				++countBot;
		}

		return Math.min(countBot, countTop);
	}

	public static void main(String[] args) {
		MinimumDominoRotations_1007 min = new MinimumDominoRotations_1007();
		int[] A = { 2, 1, 2, 4, 2, 2 }, B = { 5, 2, 6, 2, 3, 2 };
		System.out.println(min.minDominoRotations(A, B));

	}

}
