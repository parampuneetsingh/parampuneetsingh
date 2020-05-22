public class FirstUniqueCharacter {

	public int UniqueCharacter(String str) {
		int[] freq = new int[26];
		for(int i = 0; i < str.length(); i ++)
            freq [str.charAt(i) - 'a'] ++;
        for(int i = 0; i < str.length(); i ++)
            if(freq [str.charAt(i) - 'a'] == 1)
                return i;
        return -1;
	}

    public int firstUniqChar(String s) {
        int[] a = new int[26];
        for (char i:s.toCharArray()) {
            a[i - 'a']++;
        }
        
        for (int j=0; j< a.length; j++) {
            if (a[j]==1) {
                return j;
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		String str = "leetcode";
		FirstUniqueCharacter frst = new FirstUniqueCharacter();
		System.out.println(frst.firstUniqChar(str));
	}
}