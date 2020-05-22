
public class RepeatedStingMatch_686 {

	public int repeatedStringMatch(String A, String B) {
        if (A.length() > B.length()) {
            return -1;
        }
        
        StringBuilder a = new StringBuilder(A);
        int count = 1;
        for (;a.length()<B.length();) {
        	a.append(A);
        	count++;
        	if (a.toString().contains(B)) {
        		return count;
        	}
        	if (a.append(A).toString().contains(B)) {
        		return count+1;
        	}
        }
        return -1; 
    }
	
	public static void main(String[] args) {
		RepeatedStingMatch_686 match = new RepeatedStingMatch_686();
		int count = match.repeatedStringMatch("abcd", "cdabcdab");
		System.out.println(count);
	}

}
