
public class FillingBookcaseShelves_1105 {

	public static int minHeightShelves(int[][] books, int shelf_width) {
		if (books == null || books.length == 0 || books[0].length == 0)
			return 0;
		int[] dp = new int[books.length];
		dp[0] = books[0][1];

		for (int i = 1; i < books.length; ++i) {
			int curW = books[i][0];
			int curH = books[i][1];
			dp[i] = dp[i - 1] + books[i][1];
			for (int j = i - 1; j >= 0; --j) {
				if (books[j][0] + curW <= shelf_width) {
					curH = Math.max(curH, books[j][1]);
					int temp = j > 0 ? curH + dp[j - 1] : curH;
					dp[i] = Math.min(dp[i], temp);
					curW += books[j][0];
				} else {
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
		int shelf_width = 4;
		System.out.println(minHeightShelves(books, shelf_width));
	}

}
