//https://www.youtube.com/watch?v=QqcfMNQG6Ws

public class LeftmostColumnwithatLeastaOne {

	public int leftMostColumnWithOne(int[][] binaryMatrix) {
		int res = -1, idx = -1;
		int row = binaryMatrix.length, col = binaryMatrix[0].length;
		int r = 0, c = col - 1;

		while (r < row && c >= 0) {
			idx = binaryMatrix[r][c];

			if (idx == 1) {
				res = c;
			}

			if (idx == 0) {
				r++;
			} else {
				c--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LeftmostColumnwithatLeastaOne impl = new LeftmostColumnwithatLeastaOne();
		int[][] binaryMatrix = { { 0, 0 }, { 1, 1 } };
		impl.leftMostColumnWithOne(binaryMatrix);
	}

}
