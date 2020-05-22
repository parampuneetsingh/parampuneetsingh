
public class EditDistance_72 {

/*	public int minDistance(String word1, String word2) {
		int[] d = new int[word2.length() + 1];
		for (int i = 0; i <= word2.length(); ++i) {
			d[i] = i;
		}
		for (int i = 1; i <= word1.length(); ++i) {
			int prev = d[0];
			d[0] = i;
			for (int j = 1; j <= word2.length(); ++j) {
				int tmp = d[j];
				d[j] = Math.min(d[j - 1], d[j]) + 1;
				d[j] = Math.min(d[j], prev + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
				prev = tmp;
			}
		}
		return d[word2.length()];
	}*/

	public int minDistance(String word1, String word2) {
		
		if (word1.isEmpty() || word2.isEmpty()) {
			return Math.abs(word2.length() - word1.length());
		}
		
		int[][] tempAry = new int[word1.length() + 1][word2.length() + 1]; // Adding 1 extra space in array because First column and row will be used from Line 34 to 40
		
		for (int i=0; i<=word1.length(); i++) {
			tempAry[i][0] = i;
		}
		
		for (int j=0; j<=word2.length(); j++) {
			tempAry[0][j] = j;
		}
		
		for (int i=1; i<=word1.length(); i++) {
			for (int j=1; j<=word2.length(); j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					tempAry[i][j] = tempAry[i-1][j-1];
				}
				else {
					tempAry[i][j] = Math.min(Math.min(tempAry[i][j-1], tempAry[i-1][j]), tempAry[i-1][j-1]) + 1;
				}
			}
		}
		return tempAry[word1.length()][word2.length()];
	}
	
	public static void main(String[] args) {
		String str1 = "distance";
		String str2 = "springbok";

		EditDistance_72 res = new EditDistance_72();
		//int resp = res.minDistance(str1, str2); // To understand Watch this. https://www.youtube.com/watch?v=We3YDTzNXEk
		//System.out.println(resp);
		System.out.println(Math.sqrt(8));
	}
}
