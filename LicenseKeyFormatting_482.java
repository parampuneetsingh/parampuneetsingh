
public class LicenseKeyFormatting_482 {
	//Solution2
	public static String licenseKeyFormatting2(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int i = S.length()-1;
        int counter = 0;
        
        while (i>=0) {
            if (S.charAt(i) == '-') {
                i--;
            }
            else if (counter == K && counter != 0) {
                sb.insert(0, '-');
                counter = 0;
            }
            else {
                sb.insert(0,S.charAt(i));
                counter++;
                i--;
            }
        }
        
        return sb.toString().toUpperCase();
    }
	
	public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        
        int counter = 0;
        for (int i=S.length()-1; i>=0; i--) {
            if (Character.isLetterOrDigit(S.charAt(i))) {
                sb.insert(0,S.charAt(i));
                counter++;
            } 
            else if (counter != 0 && counter % K == 0) {
                sb.insert(0, '-');
                counter = 0;
            } 
        }
        
        return sb.toString().toUpperCase();
    }
	
	public static void main(String[] args) {
		String S = "2-5g-3-J";
		int K = 2;
		licenseKeyFormatting2(S, K);
	}

}
