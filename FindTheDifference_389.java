
public class FindTheDifference_389 {

    public static char findTheDifference(String s, String t) {
        int[] a = new int[26];
        char c = 0;
        
        for (int j=0; j<t.length(); j++) {
            a[t.charAt(j) - 'a']++;
        }
        
        for (int i=0; i<s.length(); i++) {
            a[s.charAt(i) - 'a']--;
        }
        
        for (int k=0; k<a.length; k++) {
            if (a[k] != 0) {
                c = (char) (k + 'a');
                break;
            }
        }
        return c;
    }
    
	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		
		findTheDifference(s, t);
	}

}
