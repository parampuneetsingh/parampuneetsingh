//https://leetcode.com/problems/flood-fill/
public class FloodFill_733 {

	public static void fillColors(int[][] image, int i, int j, int color, int newColor) {
		if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color) {
			return;
		}

		image[i][j] = newColor;
		fillColors(image, i - 1, j, color, newColor);
		fillColors(image, i + 1, j, color, newColor);
		fillColors(image, i, j - 1, color, newColor);
		fillColors(image, i, j + 1, color, newColor);

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		if (image[sr][sc] == newColor) {
			return image;
		}

		fillColors(image, sr, sc, image[sr][sc], newColor);

		return image;
	}

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, newColor = 2;
		System.out.println(floodFill(image, sr, sc, newColor));
	}

}
