
public class permutationInString {

	public boolean checkInclusion(String s1, String s2) {

		int[] tempBuf = new int[26];
		int tempCount = 0;
		boolean res = false;
		
		for (int i = 0; i < s1.length(); i++) {
			tempBuf[s1.charAt(i) - 'a']++;
		}

		int[] indexBuf = tempBuf;
		for (int j = 0; j < s2.length(); j++) {
			if (indexBuf[s2.charAt(j) - 'a'] >= 1) {
				indexBuf[s2.charAt(j) - 'a']--;
				tempCount++;
			} 
			else if (tempCount != 0) {
				tempCount = 0;
				indexBuf = tempBuf;
			}

			if (tempCount == s1.length()) {
				res = true;
				break;
			} 
		}
		
		return res;
	}

	public static void main(String[] args) {
		permutationInString perm = new permutationInString();
		perm.checkInclusion("adc", "dcda");
	}

}
