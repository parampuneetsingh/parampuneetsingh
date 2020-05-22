
public class ValidPalindrome_125 {

	public boolean isPalindrome(String s) {
        int head=0;
        int tail=s.length() - 1;
        
        while(head < tail) {
          if (!Character.isLetterOrDigit(s.charAt(head))) {
            head++;              
          }
        else if (!Character.isLetterOrDigit(s.charAt(tail))) {
            tail--;
        }
        else if (s.charAt(head) != s.charAt(tail)) {
            return false;
            }
        else {
            head++;
            tail--;
        }
        }
        return true;
    }

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		//String str = "Aa";
		
		ValidPalindrome_125 pld = new ValidPalindrome_125();
		pld.isPalindrome(str.toLowerCase());
	}

}
