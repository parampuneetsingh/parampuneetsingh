import java.util.Stack;

public class BackspaceStringCompare_844 {

	//Solution 2 with constant space
	public static boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
	
    public static boolean backspaceCompare(String S, String T) {
        //Solution 1
        Stack<Character> stk1 = new Stack<Character>();
        Stack<Character> stk2 = new Stack<Character>();
        
        for (int i=0; i<S.length(); i++) {
        	if (S.charAt(i) != '#') {
                stk1.push(S.charAt(i));
            } else if (!stk1.empty()) {
                stk1.pop();
            }
        }
        
        for (int j=0; j<T.length(); j++) {
            if (T.charAt(j) != '#') {
                stk2.push(T.charAt(j));
            } else if (!stk2.empty()) {
                stk2.pop();
            }
        }
        
        return stk1.equals(stk2);
    }
    
	public static void main(String[] args) {
		String S = "ab#c";
		String T = "ad#c";
		
		System.out.println(backspaceCompare2(S, T));
	}

}
