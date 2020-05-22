//https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
//https://www.youtube.com/watch?v=t4J-Sp3BWh4

public class MaximumSideLengthOfSquare_1292 {

	public int maxSideLength(int[][] mat, int threshold) {
		int r = mat.length, c = mat[0].length;
		int res = 0, l = 0;

		int[][] tempMatrix = new int[r + 1][c + 1];

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				tempMatrix[i][j] = tempMatrix[i - 1][j] + tempMatrix[i][j - 1] - tempMatrix[i - 1][j - 1] + mat[i-1][j-1];
			}
		}        
		
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				while (i + l <= r && j + l <= c && tempMatrix[i + l][j + l] - tempMatrix[i + l][j]
						- tempMatrix[i][j + l] + tempMatrix[i][j] <= threshold) {
					res = l;
					l++;
				}
			}
		}

		return res;
	}
	
	/*
	[0, 0, 0, 0, 0], 
	[0, 1, 2, 3, 4], 
	[0, 2, 3, 4, 5], 
	[0, 3, 4, 5, 6], 
	[0, 4, 5, 6, 7]
	*/

	public static void main(String[] args) {
		MaximumSideLengthOfSquare_1292 max = new MaximumSideLengthOfSquare_1292();
		int[][] mat = { { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
		System.out.println(max.maxSideLength(mat, 6));
	}

}
