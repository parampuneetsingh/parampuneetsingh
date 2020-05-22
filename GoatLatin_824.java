import java.util.ArrayList;
import java.util.List;


public class GoatLatin_824 {

	public static String toGoatLatin(String S) {
        List<Character> vowels = new ArrayList<Character>();
        //StringBuilder str = new StringBuilder();
        String str = "";
        char[] v = {'a','i','o','u','e','A','I','O','U','E'};
        
        int counter = 1;
        
        for (char c:v) {
            vowels.add(c);
        }
                    
        for (String word:S.split(" ")) {
            char firstChar = word.charAt(0);
            if (vowels.contains(firstChar)) {
                str += word+"ma";
            } else {
                str +=word.substring(1)+firstChar+"ma";
            }
        
            for (int j=0; j<counter; j++) {
                str +='a';
            }
            counter++;
            str +=" ";
        }
           return str;
    }
	 
	public static void main(String[] args) {
		toGoatLatin("I speak Goat Latin");
	}
}
